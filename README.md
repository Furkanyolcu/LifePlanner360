# LifePlanner360
LifePlanner360 is a comprehensive planning application to organize your events and tasks. With weather integration, Outlook calendar sync, and productivity analytics, manage your plans effortlessly and achieve your goals.

## 🛠️ Technologies Used

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Weather API](https://img.shields.io/badge/Weather%20API-00C6FF?style=for-the-badge&logo=icloud&logoColor=white)
![SMTP](https://img.shields.io/badge/SMTP-FF4500?style=for-the-badge&logo=gmail&logoColor=white)


LifePlanner360: Your All-in-One Life Organizer
LifePlanner360 is a powerful and user-friendly event and task planning application designed to help you organize your daily, weekly, and long-term activities effortlessly. With LifePlanner360, you can stay on top of your plans, track progress, and maximize productivity.

Key Features:
Task and Event Management: Add tasks or events with start and end dates, and mark them as completed once you're done.
Weather Integration: Make informed decisions with real-time weather data integrated directly into your planner.
Productivity Dashboard: Gain insights into your progress with statistics like account creation date, total plans, and completed tasks.
Outlook Calendar Sync: Seamlessly synchronize your plans with Microsoft Outlook to receive reminders and email notifications.
User-Friendly Interface: Designed with simplicity and functionality in mind for a smooth user experience.
Why LifePlanner360?
LifePlanner360 combines the essential tools for personal organization, task tracking, and productivity enhancement into a single app. Whether you're planning a small event or managing a busy schedule, LifePlanner360 ensures you're always prepared.


## Database Setup

Run the following SQL commands to create the database and tables required for this project:

```sql
-- Create database
CREATE DATABASE plan CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Use the database
USE plan;

-- Create `user` table
CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `date` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create `myplans` table
CREATE TABLE `myplans` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `plans` VARCHAR(500) NOT NULL,
  `startDate` DATE DEFAULT NULL,
  `endDate` DATE DEFAULT NULL,
  `dateCreated` DATE DEFAULT NULL,
  `status` VARCHAR(100) NOT NULL,
  `planner` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
``` 
### Steps to Setup Database
1. Open your database management tool (e.g., phpMyAdmin, MySQL Workbench).
2. Copy the SQL code above.
3. Run the SQL commands to create the database and tables.
4. Verify the `plan` database and its tables (`user` and `myplans`) are created successfully.

