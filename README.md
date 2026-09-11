# PrepForge: Interview Preparation Portal

PrepForge is a beginner-friendly Java web application built to help students
prepare for technical interviews, while also serving as a hands-on learning
project for core Java and web development concepts.

It is designed for students taking an **Introduction to Java Programming**
course (or similar) who want a realistic, full-stack Spring Boot project to
learn from and extend — not just a toy exercise.
 
---

## What This Project Is About

Technical interviews for software roles typically test knowledge across
several core computer science subjects — Java, Object-Oriented Programming,
DBMS, Operating Systems, Computer Networks, and Algorithms. PrepForge brings
these together in one place, letting students:

- Browse and search a library of interview questions by category and difficulty
- Attempt multiple-choice quizzes and get instant, explained results
- Bookmark questions to revisit later
- Mark questions as solved and track their progress over time
- View a personal dashboard summarizing their preparation activity
  Meanwhile, admins (instructors, TAs, or content managers) can:

- Create, update, and delete interview questions
- Build multiple-choice quizzes
- View platform-wide stats: total users, total questions, total quiz attempts
- Review recent quiz attempts across all students
  Beyond being a study tool, the project is intentionally built with a **clean,
  layered architecture** (Controller → Service → Repository → Model) so it also
  works as a teaching example of how a real Spring Boot application is
  structured, without unnecessary complexity like microservices, JWT, or
  front-end frameworks.

---

## Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring MVC**
- **Thymeleaf** (server-rendered HTML templates)
- **Spring Data JPA** (database access)
- **H2 Database** (in-memory, for development)
- **Bootstrap / simple CSS** (styling)
- **Maven** (build tool)
  Deliberately **not** used: React/Angular, microservices, JWT auth,
  WebSockets, AI APIs, online code execution, payment systems, or complex
  design patterns — to keep the codebase approachable for beginners.

---

## Core Features

1. **User Authentication** — Registration, login, and simple session-based
   auth with two roles: `STUDENT` and `ADMIN`.
2. **Interview Question Library** — Searchable and filterable by category
   (Java, OOP, DBMS, Operating Systems, Computer Networks, Algorithms) and
   difficulty (`EASY`, `MEDIUM`, `HARD`).
3. **Question Management** — Admins can create, update, and delete questions
   with validation and clear feedback messages.
4. **Quiz System** — Admin-created multiple-choice quizzes, student attempts,
   automatic scoring, and post-submission explanations.
5. **Student Progress Tracking** — Bookmarks, solved-question tracking, and a
   personal progress dashboard.
6. **Admin Dashboard** — Platform stats and quick links to manage content.
---

## Project Structure

```
src/main/java/com/prepforge/
├── controller/     # Handles HTTP requests and routes them to services
├── service/        # Contains business logic (kept out of controllers)
├── repository/     # Spring Data JPA interfaces for database access
├── model/          # JPA entities and enums (User, InterviewQuestion, etc.)
├── dto/            # Data Transfer Objects for form input/output
├── exception/      # Custom exceptions and centralized error handling
└── config/         # Application configuration (sessions, data seeding)
```

This project is being built **incrementally**:

1. Database model + question library
2. Authentication (registration, login, roles)
3. Quiz system
4. Bookmarks, solved questions, and dashboards
   Each stage will be explained as it's implemented, along with how to manually
   test it.

---

## Status

🚧 **In progress.** The repository currently contains the project skeleton
(folder and package structure) with no implementation yet. Code will be added
feature by feature, following the development order above.
 
---

## Getting Started

Setup instructions (Maven build steps, running with `mvn spring-boot:run`,
accessing the H2 console, and default sample data/credentials) will be added
here once the first working version of the application is complete.
 
---

## Future Scalability Ideas

- Replace H2 with a persistent database (PostgreSQL/MySQL) for production
- Add pagination for large question/quiz lists
- Introduce a REST API layer for a future mobile or SPA front end
- Add email verification and password reset flows
- Support timed quizzes and difficulty-based scoring
- Add analytics on commonly missed questions/topics
 
