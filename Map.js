import React, { useEffect, useState } from "react";

const MapPage = () => {
    const [tracking, setTracking] = useState(false); // Toggle tracking
    const [locationName, setLocationName] = useState("Loading location...");
    const [time, setTime] = useState(() => new Date().toLocaleString());
    const [metrics, setMetrics] = useState({
        miles: 0.0,
        pace: "0'00\"",
        timeElapsed: "0:00",
        calories: 0,
        elevation: "0 ft",
        cadence: 0,
    });

    useEffect(() => {
        let map, marker, startTime, lastPosition = null;

        const initMap = () => {
            const defaultLocation = { lat: 21.885, lng: -159.465 }; // Fallback: Kauai, Hawaii
            map = new google.maps.Map(document.getElementById("map"), {
                center: defaultLocation,
                zoom: 13,
            });

            marker = new google.maps.Marker({
                position: defaultLocation,
                map: map,
                title: "Starting Point",
            });

            if (navigator.geolocation) {
                navigator.geolocation.watchPosition(
                    (position) => {
                        const userLocation = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude,
                        };

                        // Update map and marker
                        map.setCenter(userLocation);
                        marker.setPosition(userLocation);

                        // Reverse geocode the user's location
                        const geocoder = new google.maps.Geocoder();
                        geocoder.geocode({ location: userLocation }, (results, status) => {
                            if (status === "OK" && results[0]) {
                                setLocationName(results[0].formatted_address);
                            } else {
                                console.error("Geocoding failed:", status);
                                setLocationName("Unable to Retrieve Location");
                            }
                        });

                        // Update metrics only if tracking
                        if (tracking) {
                            if (!startTime) startTime = Date.now();

                            // Calculate metrics
                            if (lastPosition) {
                                const distance = calculateDistance(
                                    lastPosition.lat,
                                    lastPosition.lng,
                                    userLocation.lat,
                                    userLocation.lng
                                );

                                if (distance > 0.1) {
                                    const elapsedTime = Math.floor((Date.now() - startTime) / 1000); // Seconds
                                    const minutes = Math.floor(elapsedTime / 60);
                                    const seconds = elapsedTime % 60;

                                    setMetrics((prev) => ({
                                        ...prev,
                                        miles: (prev.miles + distance).toFixed(2),
                                        timeElapsed: `${minutes}:${seconds < 10 ? "0" : ""}${seconds}`,
                                        calories: Math.floor((prev.miles + distance) * 100),
                                    }));
                                }
                            }
                            lastPosition = userLocation;
                        }
                    },
                    (error) => {
                        console.error("Error getting location:", error);
                        setLocationName("Location Unavailable");
                    },
                    { enableHighAccuracy: true }
                );
            } else {
                setLocationName("Geolocation Not Supported");
            }
        };

        const calculateDistance = (lat1, lon1, lat2, lon2) => {
            const R = 3958.8; // Radius of Earth in miles
            const dLat = ((lat2 - lat1) * Math.PI) / 180;
            const dLon = ((lon2 - lon1) * Math.PI) / 180;
            const a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos((lat1 * Math.PI) / 180) *
                Math.cos((lat2 * Math.PI) / 180) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2);
            const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            return R * c; // Distance in miles
        };

        // Load the Google Maps API and initialize the map
        const script = document.createElement("script");
        script.src = `https://maps.googleapis.com/maps/api/js?key=AIZaSyDQrJfZcoihNW215vUAzs3o5BcnyJokOk8&callback=initMap`;
        script.async = true;
        script.defer = true;
        document.body.appendChild(script);
        script.onload = initMap;
    }, [tracking]);

    return (
        <div style={{ color: "#fff", backgroundColor: "#000", minHeight: "100vh" }}>
            <header style={{ padding: "20px", backgroundColor: "#1a1a1a", textAlign: "center" }}>
                <h1>{locationName}</h1>
                <p>{time}</p>
            </header>
            <div className="metrics" style={{ display: "grid", gridTemplateColumns: "repeat(3, 1fr)", gap: "10px", padding: "20px", backgroundColor: "#1a1a1a" }}>
                <div className="metric">
                    <h2>{metrics.miles}</h2>
                    <p>Miles</p>
                </div>
                <div className="metric">
                    <h2>{metrics.pace}</h2>
                    <p>Avg. Pace</p>
                </div>
                <div className="metric">
                    <h2>{metrics.timeElapsed}</h2>
                    <p>Time</p>
                </div>
                <div className="metric">
                    <h2>{metrics.calories}</h2>
                    <p>Calories</p>
                </div>
                <div className="metric">
                    <h2>{metrics.elevation}</h2>
                    <p>Elevation Gain</p>
                </div>
                <div className="metric">
                    <h2>{metrics.cadence}</h2>
                    <p>Cadence</p>
                </div>
            </div>
            <button
                onClick={() => setTracking((prev) => !prev)}
                style={{
                    display: "block",
                    margin: "20px auto",
                    padding: "10px 20px",
                    border: "none",
                    borderRadius: "8px",
                    backgroundColor: tracking ? "#ff0000" : "#00ff85",
                    color: "#000",
                    fontWeight: "bold",
                    cursor: "pointer",
                }}
            >
                {tracking ? "Stop Run" : "Start Run"}
            </button>
            <div id="map" style={{ height: "40vh", width: "90%", margin: "20px auto", borderRadius: "10px", boxShadow: "0 4px 8px rgba(0, 255, 133, 0.2)" }}></div>
        </div>
    );
};

export default MapPage;
