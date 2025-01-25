# LifePlanner360
LifePlanner360 is a comprehensive planning application to organize your events and tasks. With weather integration, Outlook calendar sync, and productivity analytics, manage your plans effortlessly and achieve your goals.

## 🛠️ Technologies Used

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Weather API](https://img.shields.io/badge/Weather%20API-00C6FF?style=for-the-badge&logo=icloud&logoColor=white)
![SMTP (Gmail)](https://img.shields.io/badge/SMTP%20(Gmail)-FF4500?style=for-the-badge&logo=gmail&logoColor=white)
![Microsoft Outlook](https://img.shields.io/badge/Microsoft%20Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=white)

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

Customize the following sections by adding your own API keys and email credentials to make the application work seamlessly.
![Ekran görüntüsü 2025-01-25 202054](https://github.com/user-attachments/assets/6f6fb76e-04a6-4230-9c62-a40c27208427)
![Ekran görüntüsü 2025-01-25 201927](https://github.com/user-attachments/assets/57401c0a-38fb-49c8-841f-86574d86b751)

The following screenshots showcase the application's interface and functionality when running successfully.

![Ekran görüntüsü 2025-01-25 195503](https://github.com/user-attachments/assets/3e1f582c-dc36-4fd2-8476-d5fa6ff13254)
![Ekran görüntüsü 2025-01-25 213204](https://github.com/user-attachments/assets/f81ca024-9fb9-431d-b7ab-0831cdc05b99)
![Ekran görüntüsü 2025-01-25 200754](https://github.com/user-attachments/assets/41f04dd8-6519-41cc-98cc-225508a31ea3)
![Ekran görüntüsü 2025-01-25 200855](https://github.com/user-attachments/assets/2ba8c9ef-e063-4e03-b1d9-cacd5f627b35)
![Ekran görüntüsü 2025-01-25 200833](https://github.com/user-attachments/assets/a9b6a814-52f3-4f4c-93d0-233e9e4ecb90)





























