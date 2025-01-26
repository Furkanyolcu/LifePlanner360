# LifePlanner360

LifePlanner360 is a comprehensive planning application to organize your events and tasks. With weather integration, Outlook calendar sync, and productivity analytics, manage your plans effortlessly and achieve your goals.

---

## 🛠️ Technologies Used

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=openjdk&logoColor=white" alt="JavaFX">
  <img src="https://img.shields.io/badge/Weather%20API-00C6FF?style=for-the-badge&logo=icloud&logoColor=white" alt="Weather API">
  <img src="https://img.shields.io/badge/SMTP%20(Gmail)-FF4500?style=for-the-badge&logo=gmail&logoColor=white" alt="SMTP (Gmail)">
  <img src="https://img.shields.io/badge/Microsoft%20Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=white" alt="Microsoft Outlook">
</p>

---

## 💡 Features

- **Task and Event Management**: Add tasks or events with start and end dates, and mark them as completed once you're done.
- **Weather Integration**: Make informed decisions with real-time weather data integrated directly into your planner.
- **Productivity Dashboard**: Gain insights into your progress with statistics like account creation date, total plans, and completed tasks.
- **Outlook Calendar Sync**: Seamlessly synchronize your plans with Microsoft Outlook to receive reminders and email notifications.
- **User-Friendly Interface**: Designed with simplicity and functionality in mind for a smooth user experience.

---

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

Steps to Setup Database
Open your database management tool (e.g., phpMyAdmin, MySQL Workbench).
Copy the SQL code above.
Run the SQL commands to create the database and tables.
Verify the plan database and its tables (user and myplans) are created successfully. 


🖼️ Screenshots
The following screenshots showcase the application's interface and functionality when running successfully:





<div align="center">
  <img src="https://github.com/user-attachments/assets/3e1f582c-dc36-4fd2-8476-d5fa6ff13254" alt="Dashboard Screenshot" width="60%">
</div>

<div align="center">
  <img src="https://github.com/user-attachments/assets/3423ac95-5d20-4d62-9836-605ac139dc55" alt="Screenshot" width="60%">
</div>

<div align="center">
  <img src="https://github.com/user-attachments/assets/41f04dd8-6519-41cc-98cc-225508a31ea3" alt="Add Plan Screenshot" width="60%">
</div>

<div align="center">
  <img src="https://github.com/user-attachments/assets/2ba8c9ef-e063-4e03-b1d9-cacd5f627b35" alt="Weather Integration Screenshot" width="60%">
</div>

<div align="center">
  <img src="https://github.com/user-attachments/assets/a9b6a814-52f3-4f4c-93d0-233e9e4ecb90" alt="Outlook Calendar Sync Screenshot" width="60%">
</div>

<div align="center">
  <img src="https://github.com/user-attachments/assets/e28345d9-ecbe-4518-b1d4-c92d9a1cb28e" alt="Weather API Key Placeholder" width="70%">
</div>

<div align="center">
  <img src="https://github.com/user-attachments/assets/4d54d1fd-c353-43f0-8b8c-d55f1ccde616" alt="Email Configuration Placeholder" width="70%">
</div>






📝 Notes

API Configuration: Ensure to replace placeholders like <API_KEY> and <EMAIL> with your actual credentials in the project.
SMTP Email: Update the email sender and password fields to your SMTP credentials for Gmail.

🚀 Getting Started

Clone the repository:
bash
Kopyala
Düzenle
git clone https://github.com/Furkanyolcu/LifePlanner360.git
Open the project in your IDE.
Configure the database and API keys as described above.
Run the application.
















