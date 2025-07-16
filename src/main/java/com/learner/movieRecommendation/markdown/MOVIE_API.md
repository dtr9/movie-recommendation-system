# 🎬 Trie-Based Movie Recommendation API

This service provides a lightweight movie recommendation engine using a prefix-matching Trie data structure. It allows adding movies with ranks, retrieving all movies, and querying top N movies by name prefix.

---

## 📌 Base URL

```
http://localhost:8080/movie-recommendation/simulator
```

---

## 🔧 Endpoints

### 1. **Add a Movie**

**Endpoint:**  
`POST /movie`

**Description:**  
Adds a new movie to the Trie-based recommendation engine.

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

**Endpoint:**  
`GET /movies`

**Description:**  
Returns a list of all movies that have been added.

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

**Endpoint:**  
`POST /top`

**Description:**  
Returns the top N ranked movies whose names start with a given prefix.

**Request Body:**
```json
{
  "prefix": "Spid",
  "n": 3
}
```

**Sample Response:**
```json
{
  "topMovies": ["Spider-Man: Homecoming", "Spiderman", "Spiderverse"]
}
```

---

## 🧪 Sample `curl` Commands

### ✅ Add Movies

```bash
curl -X POST http://localhost:8080/movie-recommendation/simulator/movie   -H "Content-Type: application/json"   -d '{"name": "Batman", "rank": 95}'
```

You can use this command with different movie names and ranks to populate the database.

---

### ✅ Get All Movies

```bash
curl http://localhost:8080/movie-recommendation/simulator/movies
```

---

### ✅ Get Top Movies by Prefix

```bash
curl -X POST http://localhost:8080/movie-recommendation/simulator/top   -H "Content-Type: application/json"   -d '{"prefix": "Spid", "n": 3}'
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

## 📘 Notes

- Ranking is a positive integer; higher rank = higher priority in top N.
- Trie is case-sensitive by default. Prefix `"spid"` ≠ `"Spid"`.
- All movies are stored in-memory only and will be lost on restart unless persisted.

---

Happy Testing! 🎥


---

## 📜 Full Add Movie `curl` Commands

Use the following to quickly populate 50 movies into the recommender system:

```bash
endpoint="http://localhost:8080/movie-recommendation/simulator/movie"

curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Batman", "rank": 95}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Batwoman", "rank": 90}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Batboy", "rank": 88}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Black Panther", "rank": 93}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Black Widow", "rank": 89}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Blade", "rank": 84}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Brave", "rank": 80}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Bridesmaids", "rank": 77}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Brooklyn", "rank": 82}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Cars", "rank": 79}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Cinderella", "rank": 85}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Captain America", "rank": 91}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Captain Marvel", "rank": 90}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Coco", "rank": 92}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Creed", "rank": 86}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Deadpool", "rank": 94}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Doctor Strange", "rank": 89}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Dune", "rank": 90}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Eternals", "rank": 82}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Encanto", "rank": 87}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Everything Everywhere All at Once", "rank": 96}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Frozen", "rank": 88}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Forrest Gump", "rank": 94}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Gladiator", "rank": 89}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Gravity", "rank": 87}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Guardians of the Galaxy", "rank": 90}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Harry Potter", "rank": 93}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Hulk", "rank": 85}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Inception", "rank": 97}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Interstellar", "rank": 96}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Iron Man", "rank": 92}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Joker", "rank": 91}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Jumanji", "rank": 84}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Justice League", "rank": 86}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Luca", "rank": 83}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Logan", "rank": 89}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Moana", "rank": 86}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Mulan", "rank": 87}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "No Time to Die", "rank": 85}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Ratatouille", "rank": 92}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Shang-Chi", "rank": 90}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Shazam", "rank": 84}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Soul", "rank": 89}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Spider-Man: Homecoming", "rank": 94}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Spiderman", "rank": 91}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Spiderverse", "rank": 90}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Thor", "rank": 88}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Wonder Woman", "rank": 90}'
curl -s -X POST $endpoint -H "Content-Type: application/json" -d '{"name": "Zootopia", "rank": 85}'
```

---

