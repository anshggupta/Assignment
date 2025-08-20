# 🌍 Tour Package Management Microservice

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.0-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)
![AWS S3](https://img.shields.io/badge/AWS-S3-orange?style=for-the-badge&logo=amazonaws)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue?style=for-the-badge&logo=docker)
![Deployment](https://img.shields.io/badge/Deployed-AWS%20EC2-lightgrey?style=for-the-badge&logo=amazonec2)

---

## 📌 Overview
A **Spring Boot microservice** to manage **Tour Packages** with:
- 🗄️ PostgreSQL Database
- ☁️ Image Upload to **AWS S3**
- 🐳 Dockerized deployment on **AWS EC2**

---

## 🚀 Features
✅ CRUD APIs for Tour Packages  
✅ Image upload to AWS S3  
✅ PostgreSQL integration  
✅ Dockerized deployment  
✅ Hosted on AWS EC2

---

## 🏗️ Tech Stack
- **Backend:** Java 17, Spring Boot
- **Database:** PostgreSQL
- **Storage:** AWS S3
- **Deployment:** Docker, AWS EC2

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repo

git clone https://github.com/anshggupta/Assignment.git
cd Assignment

2️⃣ Build Application

./mvnw clean package -DskipTests

3️⃣ Run with Docker

Start PostgreSQL

docker run -d --name postgres_db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=Gpak#1234 \
  -e POSTGRES_DB=mapmytripdb \
  -p 5432:5432 postgres:15

Run Spring Boot App

docker run -d --name springboot_app \
  --link postgres_db:postgres \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/mapmytripdb \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=Gpak#1234 \
  -p 8080:8080 anshggupta/docker-springboot-app

### 📖 API Documentation
🌍 Base URLs

Environment	URL

Local	http://localhost:8080

AWS EC2	http://13.127.196.184:8080/api/tours

🔹 1. Create Tour Package
POST /api/tours

Request:

{
  "id": 1,
  "image": "https://images.unsplash.com/photo-1598275277521-1885382d523a",
  "discountInPercentage": "17%",
  "title": "Himalayan Trek Adventure",
  "description": "14-day trek through the Himalayas",
  "duration": "14Days/13Nights",
  "actualPrice": "$1200",
  "discountedPrice": "$1000",
  "currency": "USD",
  "location": "leh"
}
cURL:

curl -X POST http://13.127.196.184:8080/api/tours \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "image": "https://images.unsplash.com/photo-1598275277521-1885382d523a",
    "discountInPercentage": "17%",
    "title": "Himalayan Trek Adventure",
    "description": "14-day trek through the Himalayas",
    "duration": "14Days/13Nights",
    "actualPrice": "$1200",
    "discountedPrice": "$1000",
    "currency": "USD",
    "location": "leh"
  }'

🔹 2. List All Packages
GET /api/tours


curl http://13.127.196.184:8080/api/tours

🔹 3. Get Package by ID
GET /api/tours/{id}

curl http://13.127.196.184:8080/api/tours/1

🔹 4. Upload / Replace Image
POST /api/tours/{id}/image

curl -X POST http://13.127.196.184:8080/api/tours/1/image \
  -F "file=@/path/to/local/image.jpg"

### 📬 Postman Collection
📂 postman_collection.json → Import into Postman to test all APIs

### ☁️ AWS S3 Integration
Bucket: map-my-tour-bucket

Region: ap-south-1

application.properties

properties

cloud.aws.s3.bucket=map-my-tour-bucket

cloud.aws.region.static=ap-south-1

### 🚀 Deployment on AWS EC2
SSH into EC2

Install Docker

Pull Docker Image:

docker pull anshggupta/docker-springboot-app
Run PostgreSQL + App containers

### Access API: 👉 http://13.127.196.184:8080/api/tours

📂 Project Structure

Assignment/
├── src/                 # Spring Boot source code
├── Dockerfile           # Docker build file
├── postman_collection.json
├── README.md
└── pom.xml

### 🔗 Deployed Link
👉 http://13.127.196.184:8080/api/tours

📝 Author

👨‍💻 Ansh Gupta