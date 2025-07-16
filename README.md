# 🎬 Trie-Based Movie Recommendation API

A lightweight, in-memory recommendation engine built with Spring Boot. It uses a **Trie (prefix tree)** to store and retrieve movies efficiently by name prefixes and supports ranking-based top-N retrieval.

---

## ✨ Features

- Add movies with custom names and ranks
- Query **Top-N ranked** movies that start with a given prefix
- View all stored movies
- Trie-based prefix search optimized for fast lookup
- Simple, REST-based simulator interface
- In-memory only (fast, but ephemeral)

---

## ⚙️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Maven
- Trie Data Structure (custom implementation)
- Lombok (for boilerplate reduction)

---

## 📦 Package Structure

```
com.learner.movieRecommendation
├── model                // Movie, TrieNode classes
├── service              // MovieRecommender interface
│   └── impl             // Trie-based implementation
├── simulator
│   ├── controller       // REST controller
│   ├── dto              // Request/Response DTOs
│   └── impl             // Simulator logic for manual mode (optional)
└── MovieRecommendationApplication.java
```

---

## 📌 Base URL

```
http://localhost:8080/movie-recommendation/simulator
```

---

## 🔧 Endpoints

### 1. **Add a Movie**

**POST** `/movie`  
Adds a new movie with a rank.

**Request Body:**
```json
{
  "name": "Batman",
  "rank": 95
}
```

**Response:**
```
Movie added successfully
```

---

### 2. **Get All Movies**

**GET** `/movies`  
Returns all movies in the system.

**Sample Response:**
```json
[
  {"name": "Batman", "rank": 95},
  {"name": "Spiderverse", "rank": 90},
  {"name": "Black Panther", "rank": 93}
]
```

---

### 3. **Get Top N Movies by Prefix**

**POST** `/top`  
Returns the top N ranked movies that start with a given prefix.

**Request Body:**
```json
{
  "prefix": "Spid",
  "n": 3
}
```

**Response:**
```json
{
  "topMovies": ["Spider-Man: Homecoming", "Spiderman", "Spiderverse"]
}
```

---

## 🧪 Sample `curl` Commands

### ➕ Add Movies

```bash
curl -X POST http://localhost:8080/movie-recommendation/simulator/movie \
     -H "Content-Type: application/json" \
     -d '{"name": "Batman", "rank": 95}'
```

### 📥 Get All Movies

```bash
curl http://localhost:8080/movie-recommendation/simulator/movies
```

### 📊 Get Top Movies by Prefix

```bash
curl -X POST http://localhost:8080/movie-recommendation/simulator/top \
     -H "Content-Type: application/json" \
     -d '{"prefix": "Spid", "n": 3}'
```

---

## 📂 DTO Structures

### `AddMovieRequest`
```json
{
  "name": "string",
  "rank": 0
}
```

### `TopNQueryRequest`
```json
{
  "prefix": "string",
  "n": 0
}
```

### `TopNQueryResponse`
```json
{
  "topMovies": ["string"]
}
```

---

## 🧠 Design Notes

- ✅ **Trie data structure** supports fast prefix-based search.
- ✅ Ranking handled via a bounded min-heap (priority queue) to get Top N efficiently.
- ✅ State is **non-Spring-managed**, ensuring that each simulator gets isolated data.
- ❌ Data is not persisted — this is an **in-memory** simulator for learning/performance testing.

---

## 🚀 Getting Started

### 🔨 Build & Run

Make sure you’re using **Java 17+**

```bash
./mvnw spring-boot:run
```

Or, if using local Maven:

```bash
mvn clean install
java -jar target/movie-recommendation-0.0.1-SNAPSHOT.jar
```

---

## 📜 Preloaded Sample Data

Want to load 50 movies quickly? Use one of the scripts below:

### 🐧 For Mac/Linux:

```bash
# Make the script executable (only once)
chmod +x scripts/populate.sh

# Run the script
bash scripts/populate.sh
```

### 🪟 For Windows:

```bat
:: Just double-click or run from terminal
scripts\populate.bat
```

---

## 💬 Contributing

Feel free to open issues, suggest improvements, or contribute features like:
- Persistent storage
- REST client UI
- Swagger/OpenAPI support
- Multitenant isolation

---

## 📄 License

This project is open for learning and demo purposes. No license yet applied.

---

Happy Recommending! 🎥
