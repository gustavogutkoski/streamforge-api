# StreamForge API

The **StreamForge API** is the backend service for managing users, videos, and video chunks.  
It provides the foundation for a simple streaming platform, supporting video uploads in chunks to **MinIO** (
S3-compatible) with metadata stored in **PostgreSQL**.

---

## Features

- **Users**
    - Register new users
    - List user details with associated videos
- **Videos**
    - Upload complete video
    - Fetch video by ID
    - List all videos
- **Video Chunks**
    - Upload individual video chunks
    - List chunks of a video
- **Storage**
    - Integration with **MinIO** (or any S3-compatible service)

---

## Tech Stack

- **Java 21**
- **Spring Boot 3**
- **PostgreSQL 16**
- **MinIO (S3 Client)**
- **Maven** (build tool)
- **Docker**

---

## Project Structure

```
    streamforge-api
    ├── src/main/java/com/gutkoski/streamforge/api
    │ ├── user # User entities, DTOs, mapper, service
    │ ├── video # Video entities, DTOs, mapper, service, controller
    │ ├── videochunk # Video chunk entities, DTOs, mapper, service, controller
    │ ├── config # Configurations (e.g., MinIO, S3Client)
    │ └── ...
    └── pom.xml
```

---

## Getting Started

### 1. Clone the repository

```bash
    git clone https://github.com/gustavogutkoski/streamforge-api.git
    cd streamforge-api
```

### 2. Setup PostgreSQL database

Create a database named `streamforge`:

```sql
  CREATE DATABASE streamforge;
```

Configure your credentials in `application.properties`:

```
    spring.datasource.url=jdbc:postgresql://localhost:5432/streamforge
    spring.datasource.username=postgres
    spring.datasource.password=postgres
```

### 3. Run MinIO (optional via Docker)

```bash
    docker run -p 9000:9000 -p 9001:9001 \
      -e "MINIO_ROOT_USER=admin" \
      -e "MINIO_ROOT_PASSWORD=admin123" \
      quay.io/minio/minio server /data --console-address ":9001"
```

### 4. Run the application

```bash
    ./mvnw spring-boot:run
```

The API will be available at:\
`http://localhost:8080/api/v1`

## Main Endpoints

### Users

- `POST /api/v1/users` → create a new user
- `GET /api/v1/users/{id}` → get user by ID

### Videos

- `POST /api/v1/videos/upload` → upload a video
- `GET /api/v1/videos/{id}` → get video by id
- `GET /api/v1/videos` → list all videos

### Video Chunks

- `POST /api/v1/video-chunks/upload` → upload a chunk
- `GET /api/v1/video-chunks/video/{videoId}` → list chunks of a video