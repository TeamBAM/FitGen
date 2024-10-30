# FitGen
## Table of Contents
1. Overview
2. Product Specs
3. Wireframes
4. Schema   
## Overview 
This application creates a workout routine based off of demographic information entered by the user. It constructs a specialized routine targeting body areas of focus and displays the user's fitness plans, progress and exercise logs. 

## **App Evaluation**
- **Category**: Health/Fitness
- **Story**: Create at home fitness routine based off of information input from the user
- **Market**: The target audience are people who are interested in starting a fitness journey or are into their journey and need assistance with creating a routine. This in mind, any individual can utilize our app. 
- **Habit**: How often the app is used will be up to the user depending on where they are in their fitness journey and how consistent they want to be.
- **Scope**: We are strictly focused on providing routines for those who are in need a routine and can't think of one. Once this is complete, we may venture into adding features where you can connect with friends and see their fitness stats as well. We would also incorporate weekly challenges as well as track daily steps and calorie intake.
  
# Product Spec
## 1. User Stories (Required & Optional)
### Required
- User can log into & create profile page on FitGen.
- User must enter demographic information and fitness goals.
- Showcases fitness plan, progress and Exercise logs.
- Create & modify activites based on sign-in/survey information.
- Settings to make updates/changes (General, Notifications, etc.).
### Optional (nice-to-have stories)
- Track daily steps.
- Measure calorie intake based on logged data.
- Friends: connect and see each others stats.
- Weekly challenges based on fitness plan.
- Use maps to track your running path.
## 2. Screens
- Login
- Register: User signs up or logs into their account
  - First name, Last name, Email, Passwords, etc.
- Demographic Information: User inputs personal information
  - Age, weight, gender, height.
- Body Composition Goals: User sets body composition goals
  - Target Weight, Goal Fitness Level, Body Fat% (optional).
- Fitness Goals: User selects fitness objectives
  - Endurance, Speed, Strength, Flexibility.
- Confirmation Page: Displays summary of choices
  - Confirms training plan, body comp. goals and displays the name of plan. The "learn more" link is for a desciption of each plan type.
- Fitness Plan: Shows customized training schedule
  - Displays the date, target body areas & link to view routine.
- Progress Page
  - A summary of the user's progress over time with visual indicators such as charts or metrics showing improvement in fitness.
- Exercise Log:
  - Allows the user to log specific exercises completed each day with details such as sets, reps, weight used, and time spent.
- Profile Page: Displays user information and settings
     - Displays user information, goals, and a summary of fitness activity. Allows updates to profile and personal preferences. The user can also access the setting within this page
 
## 3. Navigation
**Tab Navigvation** (Tab to Screen)
- Fitness Plan
- Progress
- Exercise Log
- Profile Page

**Flow Navigation** (Screen to Screen)
- Sign-in -> Sign up -> Log in verification -> Fitness Plan -> Fitness Plan Creation -> Main App
- Sign-in -> Main App

## Wireframes
![image](https://github.com/user-attachments/assets/7add3c3b-886b-4e3d-a016-c8df6efb5a25)

## Digital Wireframes & Mockups 
![image](https://github.com/user-attachments/assets/d8f94a14-8e3e-4e2d-9fa8-7f9505346d4b)
![image](https://github.com/user-attachments/assets/14625fe5-17fd-4d10-a55c-c70a30f1318d)
![image](https://github.com/user-attachments/assets/45bacc1d-23f2-4c0e-bdde-378fff99cc1e)

## Interactive Prototype (Bonus)
![Wireframe_Prototype-1](https://github.com/user-attachments/assets/597fdb8b-c49e-4089-87b1-9d157b30c8ab)

## Schema
### Models 

**Users**
| Property  | Type      | Description                                       |
|-----------|-----------|---------------------------------------------------|
| firstName | String    | The user's first name.                            |
| lastName  | String    | The user's last name.                             |
| email     | String    | The user's email, used for login.                 |
| createdAt | timestamp | The date and time when the user was created.      |
| updatedAt | timestamp | The date and time when the user was last updated. |
| age       | number    | The user's age.                                   |
| height    | number    | The user's height in centimeters.                 |

**FitStats**
| Property | Type      | Description                                            |
|----------|-----------|--------------------------------------------------------|
| userId   | reference | References the user this fit stat belongs to.          |
| weight   | number    | The user's current weight.                             |
| bodyFat  | number    | The user's current body fat percentage.                |
| fitLevel | string    | The user's fitness level                               |
| goals    | string    | The user's fitness goals                               |
| planName | string    | The name of the fitness plan assigned to the user.     |
| createdAt| timestamp | The date and time the fitness stats were created.      |
| updatedAt| timestamp | The date and time the fitness stats were last updated. |

**WeighIns**
| Property  | Type      | Description                                           |
|-----------|-----------|-------------------------------------------------------|
| userId    | reference | References the user this weigh-in belongs to.         |
| weighDate | timestamp | The date and time of the weigh-in.                    |
| weight    | number    | The weight recorded during the weigh-in.              |
| bodyFat   | number    | The body fat percentage recorded during the weigh-in. |

**Exercises**
| Property      | Type      | Description                                    |
|---------------|-----------|------------------------------------------------|
| userId        | reference | References the user who completed the exercise.|
| exerciseName  | String    | The name of the exercise                       |
| Duration      | number    | The duration of the exercise in minutes.       |
| Reps          | number    | The number of repetitions performed.           |
| Date          | timestamp | The date and time the exercise was logged.     |

### Networking
List of networking requests by screen
- Sign In
   - (Read/GET) Check user sign in information
   - (Update/PUT) Update password if the user forgot it
- Sign Up
   - (Create/POST) Create user account
   - (Create/POST) Create user fitness profile
- Profile
   - (Update/PUT) Update plan/ account info
   - (DELETE) Delete account
- Exercise Log
   - (Read/GET) Get exercises that have been logged
   - (Update/PUT) User can edit exercise log
   - (DELETE) User can delete exercise
   - (Create/POST) User can add exercise to log
- Progress
   - (Read/GET) User gets weigh ins displayed as a timeline
   - (Update/PUT) User can edit a weigh in
   - (DELETE) User can delete a weigh in
   - (Create/POST) User can log a new weigh in 

### Progress Added 
![Alt Text](relative/path/to/your.gif)
![image](https://github.com/user-attachments/assets/93f6d9b2-7f28-4a3f-ae4c-7e331ef2ca6b)
Updated Database
![Alt Text](https://github.com/TeamBAM/FitGen/blob/main/98gm9m.gif?raw=true)
