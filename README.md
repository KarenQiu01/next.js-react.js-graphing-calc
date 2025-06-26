# TI-84 Plus CE Web Graphing Calculator

A web-based TI-84 Plus CE-inspired graphing calculator app, built with **Next.js** and **React** for the frontend and **Java (Spring Boot + exp4j)** for the backend.  
Supports basic arithmetic, scientific functions, statistics, memory operations, and graphing with window controls—just like a real TI-84 Plus CE calculator!

---

## Features

- **Calculator:** Basic and advanced math functions (sin, cos, tan, sqrt, ^, etc.)
- **Statistics:** Mean, median, mode calculation
- **Memory:** M+, M-, MR, MC support
- **Graphing:** Plot any function of `x` (with implicit multiplication, e.g., `2x+2` works)
- **Window Control:** Set graphing range via TI-84 style "Window" button/modal
- **Modern UI:** Inspired by the look and feel of a TI-84 Plus CE

---

## Frontend

- **Framework:** [Next.js](https://nextjs.org/) (React)
- **UI Library:** [React Plotly.js](https://github.com/plotly/react-plotly.js) for graphing
- **Language:** JavaScript

### Frontend Dependencies

- `react` (v18+)
- `react-dom`
- `next`
- `react-plotly.js`
- `plotly.js`

### Install Frontend Dependencies

```bash
cd graphing-calc-frontend
npm install
```

---

## Backend

- **Framework:** [Spring Boot](https://spring.io/projects/spring-boot)
- **Math Engine:** [exp4j](https://www.objecthunter.net/exp4j/) (expression evaluation for math and graphing)
- **Language:** Java 17+

### Backend Dependencies

- `spring-boot-starter-web`
- `exp4j` (add to `pom.xml`)
- (optional) `spring-boot-devtools`

### Add exp4j to Maven

Add to your `pom.xml` dependencies:
```xml
<dependency>
    <groupId>net.objecthunter</groupId>
    <artifactId>exp4j</artifactId>
    <version>0.4.8</version>
</dependency>
```

### Run Backend

```bash
cd graphing-calc-backend
./mvnw spring-boot:run
```
Or with Maven installed:
```bash
mvn spring-boot:run
```

---

## Running the App

**1. Start the backend (Java/Spring Boot):**
```bash
cd graphing-calc-backend
./mvnw spring-boot:run
```

**2. Start the frontend (Next.js/React):**
```bash
cd graphing-calc-frontend
npm run dev
```

- The frontend runs at [http://localhost:3000](http://localhost:3000)
- The backend runs at [http://localhost:8080](http://localhost:8080)

---

## Project Structure

```
/graphing-calc-frontend  # Next.js frontend
/graphing-calc-backend   # Spring Boot backend (Java)
```

---

## Future Features (Ideas)

- Trig in degrees/radians switch
- Zoom and trace graph features
- More statistics and math functions
- "Ans" and "2nd" key functionality
- Save/load window settings

---

## Credits

- Inspired by the **TI-84 Plus CE** calculator
- [Next.js](https://nextjs.org/)
- [React](https://react.dev/)
- [Plotly.js](https://plotly.com/javascript/)
- [exp4j](https://www.objecthunter.net/exp4j/)

---

## License

This project is open source under the MIT License.
