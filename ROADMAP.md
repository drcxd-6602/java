# 🚀 Java Backend Mastery Roadmap — Darshan

> **Goal:** Job-ready Java backend developer at product companies.
> **Approach:** Learn by building **ONE** evolving e-commerce / order system.
> **Time:** 2 hrs weeknights · 3 hrs weekends (~19 hrs/week) · ~4 months.
> **DSA:** handled separately (morning LeetCode) — not in this roadmap.
>
> **Every session:** `theory → exercise/quiz → implement in project`. Never end on pure theory.

---

## 📊 Phase Progress Tracker

- [ ] **Phase 0** — Ecosystem Bootstrap (how Java apps are built)
- [ ] **Phase 1** — Core Java for Backend (the parts C# didn't give you)
- [ ] **Phase 2** — Spring Boot Core + Monolith
- [ ] **Phase 3** — Persistence & Data (JPA / Hibernate / Postgres / Redis)
- [ ] **Phase 4** — Production-Grade Backend (Security, Observability, Docker)
- [ ] **Phase 5** — Microservices + Kafka (⭐ core of your ask)
- [ ] **Phase 6** — Reactive Capstone (Reactor / WebFlux)
- [ ] **Phase 7** — Deployment & CI/CD (ship it to the cloud)
- [ ] 🎓 **Final:** Portfolio-ready, deployed, interview-ready

> **How to use this file:** Each session is a checklist. Do the theory boxes, then the 🏋️ exercise, then the 🧩 quiz, then the 🛠️ project slice. Check `- [ ]` → `- [x]` as you finish. Tell Claude which session you're on.

---

# 🧱 PHASE 0 — Ecosystem Bootstrap
*Why: You know Java the language. You don't know Java the ecosystem. Fix that first. (~6 hrs)*

## Session 0.1 — The Java runtime model & setup (2 hrs)
**Objectives:** Understand JDK vs JRE vs JVM; get a working environment.
- [ ] Learn: JDK vs JRE vs JVM, bytecode, `javac` → `.class` → JVM (vs C#'s CLR/IL — direct analogy)
- [ ] Learn: what a JVM actually does (class loading, JIT, GC at a high level)
- [ ] Install JDK 21 (LTS), verify `java -version` / `javac -version`
- [ ] Install IntelliJ IDEA Community, configure JDK
- [ ] Create + run a plain `main()` from IntelliJ and from terminal
- [ ] 🏋️ **Exercise:** Compile a `.java` by hand with `javac`, run with `java`, inspect the `.class` exists. Explain in your own words what each step did.
- [ ] 🧩 **Quiz:** Why can a `.class` file run on Windows, Mac, and Linux without recompiling? What's the C# equivalent of the JVM?

## Session 0.2 — Build tools: Maven & Gradle (2 hrs)
**Objectives:** Master your #1 gap. NuGet/MSBuild → Maven/Gradle mental model.
- [ ] Learn: what a build tool does (deps, compile, test, package, run)
- [ ] Learn: Maven `pom.xml`, coordinates (groupId/artifactId/version), lifecycle phases, `mvn` commands
- [ ] Learn: Gradle `build.gradle`, tasks, when teams pick Gradle vs Maven
- [ ] Learn: dependency scopes, transitive deps, the local `~/.m2` repo
- [ ] 🏋️ **Exercise:** Create a Maven project, add a dependency (e.g. Guava), use one class from it, `mvn package`, run the jar.
- [ ] 🧩 **Quiz:** Map these C# concepts → Java: NuGet package, `.csproj`, `dotnet build`, `dotnet run`, `bin/`.

## Session 0.3 — Project anatomy & first REST app (2 hrs)
**Objectives:** See how a real Spring Boot app is laid out before diving deep.
- [ ] Learn: standard Maven directory layout (`src/main/java`, `src/main/resources`, `src/test/java`)
- [ ] Learn: packages & naming conventions (`com.darshan.ecommerce...`)
- [ ] Use **start.spring.io** to generate the e-commerce project skeleton (Web, Lombok, DevTools)
- [ ] Run it; hit `http://localhost:8080` — understand the embedded Tomcat server
- [ ] Write a trivial `@RestController` returning "hello"
- [ ] 🛠️ **PROJECT:** Initialize the `ecommerce` repo/module. Commit the skeleton. This is your app for the next 4 months.
- [ ] 🧩 **Quiz:** What is "embedded Tomcat" and why is it a big deal vs deploying a WAR to an external server?

---

# ☕ PHASE 1 — Core Java for Backend
*Why: The Java-specific parts C# habits won't cover. Concurrency goes DEEP — it underpins everything later. (~12 hrs)*

## Session 1.1 — Collections deep dive (2 hrs)
- [ ] Learn: `List`/`ArrayList`/`LinkedList`, `Set`/`HashSet`/`TreeSet`, `Map`/`HashMap`/`TreeMap`, `Queue`/`Deque`
- [ ] Learn: when to use which (Big-O + real backend scenarios)
- [ ] Learn: `equals()`/`hashCode()` contract — and why HashMap breaks without it (C# `Equals`/`GetHashCode` analogy)
- [ ] Learn: iteration, `Comparable` vs `Comparator`
- [ ] 🏋️ **Exercise:** Build an in-memory product store using the right collections; sort products by price then name.
- [ ] 🧩 **Quiz:** You put a mutable object in a `HashSet`, then mutate a field used in `hashCode()`. What breaks and why?

## Session 1.2 — Streams, lambdas, Optional (2 hrs)
- [ ] Learn: functional interfaces, lambdas, method references (`::`)
- [ ] Learn: Stream pipeline — `filter`, `map`, `flatMap`, `reduce`, `collect`, `groupingBy`, `sorted`
- [ ] Learn: `Optional` — the right way (no `.get()` abuse); vs C# nullable
- [ ] Learn: lazy evaluation & when streams DON'T help
- [ ] 🏋️ **Exercise:** Given a `List<Order>`, compute total revenue per product category using streams + `groupingBy`.
- [ ] 🧩 **Quiz:** `map` vs `flatMap` — give a concrete example where only `flatMap` works.

## Session 1.3 — Modern Java & type system (2 hrs)
- [ ] Learn: `record` (vs C# records), `sealed` classes/interfaces, `enum` with behavior
- [ ] Learn: generics deep — bounded types, wildcards (`? extends` / `? super`), type erasure (the gotcha C# devs miss)
- [ ] Learn: `var`, text blocks, switch expressions, pattern matching
- [ ] 🏋️ **Exercise:** Model the domain with records + sealed types (e.g. `sealed interface PaymentResult permits Success, Declined`).
- [ ] 🧩 **Quiz:** What is type erasure and why can't you do `new T[10]` or `instanceof List<String>`?

## Session 1.4 — Exceptions & resource management (2 hrs)
- [ ] Learn: checked vs unchecked (the big Java-vs-C# difference), when each is right
- [ ] Learn: `try-with-resources`, `AutoCloseable`, `finally`
- [ ] Learn: custom exceptions, exception hierarchy design, wrapping/chaining
- [ ] Learn: anti-patterns (swallowing, catching `Exception`, exceptions as control flow)
- [ ] 🏋️ **Exercise:** Design a clean exception hierarchy for the e-commerce domain (`OutOfStockException`, `PaymentFailedException`...).
- [ ] 🧩 **Quiz:** Why does Java have checked exceptions and C# doesn't? Argue both sides.

## Session 1.5 — Concurrency fundamentals I (2 hrs) ⭐ DEEP
- [ ] Learn: threads, `Runnable`/`Callable`, the cost of raw threads
- [ ] Learn: race conditions, visibility, `synchronized`, `volatile`, the Java Memory Model (mental model)
- [ ] Learn: `ExecutorService`, thread pools, `Future`
- [ ] 🏋️ **Exercise:** Write a buggy concurrent counter, reproduce the race, fix it 3 ways (synchronized, AtomicInteger, lock).
- [ ] 🧩 **Quiz:** What does `volatile` guarantee and what does it NOT guarantee?

## Session 1.6 — Concurrency fundamentals II + wrap (3 hrs, weekend) ⭐ DEEP
- [ ] Learn: `CompletableFuture` — compose async work (`thenApply`, `thenCompose`, `allOf`)
- [ ] Learn: `ConcurrentHashMap`, `Atomic*`, `CountDownLatch`, thread-safe design
- [ ] Learn: virtual threads (Java 21) — what they change for backend
- [ ] 🏋️ **Exercise:** Fetch 5 "product prices" concurrently with `CompletableFuture`, combine results, handle one failing.
- [ ] 🛠️ **PROJECT:** Refactor the in-memory product store (from 1.1) into a small service layer with a thread-safe catalog. Commit.
- [ ] 🧩 **Quiz:** Explain to an interviewer: thread pool vs virtual threads — when does each win?

---

# 🌱 PHASE 2 — Spring Boot Core + Monolith
*Why: The heart of Java backend. Understand DI/IoC deeply, then build the monolith. (~20 hrs)*

## Session 2.1 — IoC & Dependency Injection, under the hood (2 hrs) ⭐ DEEP
- [ ] Learn: Inversion of Control — what problem it solves (vs `new`-ing dependencies)
- [ ] Learn: the `ApplicationContext` / bean container; how Spring scans & wires beans
- [ ] Learn: `@Component`/`@Service`/`@Repository`/`@Configuration`/`@Bean`, `@Autowired`, constructor injection (preferred)
- [ ] Learn: C# analogy — ASP.NET Core `IServiceCollection`/`AddScoped` etc. — and where it differs
- [ ] 🏋️ **Exercise:** Wire a `PriceService` into an `OrderService` via constructor injection; swap the impl with a `@Primary`/`@Qualifier`.
- [ ] 🧩 **Quiz:** Why is constructor injection preferred over field `@Autowired`? Give 2 concrete reasons.

## Session 2.2 — Bean lifecycle, scopes, configuration (2 hrs) ⭐ DEEP
- [ ] Learn: bean lifecycle (instantiate → populate → init → destroy), `@PostConstruct`/`@PreDestroy`
- [ ] Learn: scopes (singleton default vs prototype vs request), the singleton gotcha
- [ ] Learn: `application.yml`, `@Value`, `@ConfigurationProperties`, profiles (`dev`/`prod`)
- [ ] 🏋️ **Exercise:** Externalize config (e.g. tax rate) via `@ConfigurationProperties`; switch values by profile.
- [ ] 🧩 **Quiz:** Two beans are singletons but one needs per-request state. What goes wrong and how do you fix it?

## Session 2.3 — REST controllers & request handling (2 hrs)
- [ ] Learn: `@RestController`, `@GetMapping`/`@PostMapping`/etc, `@PathVariable`, `@RequestParam`, `@RequestBody`
- [ ] Learn: `ResponseEntity`, status codes, content negotiation, DTOs vs entities
- [ ] Learn: REST design basics (resources, verbs, idempotency)
- [ ] 🛠️ **PROJECT:** Build the **Catalog** REST API — `GET /products`, `GET /products/{id}`, `POST /products` (in-memory for now).
- [ ] 🧩 **Quiz:** Why should you never expose JPA entities directly as your API response?

## Session 2.4 — Validation & error handling (2 hrs)
- [ ] Learn: Bean Validation (`@Valid`, `@NotBlank`, `@Email`, `@Positive`, custom validators)
- [ ] Learn: `@ControllerAdvice` / `@ExceptionHandler` — global error handling
- [ ] Learn: consistent error response shape (problem+json style)
- [ ] 🛠️ **PROJECT:** Add validation to `POST /products`; add a global exception handler returning clean JSON errors.
- [ ] 🧩 **Quiz:** Where should business-rule validation live vs input validation? Why?

## Session 2.5 — Layered architecture & the cart (2 hrs)
- [ ] Learn: controller → service → repository layering; separation of concerns; package-by-feature vs package-by-layer
- [ ] Learn: mapping DTO ↔ domain (manual or MapStruct)
- [ ] 🛠️ **PROJECT:** Build the **Cart** feature — add/remove items, compute totals — cleanly layered.
- [ ] 🧩 **Quiz:** Your service class is 600 lines. What are the signs it's doing too much, and how do you split it?

## Session 2.6 — Testing the monolith (3 hrs, weekend)
- [ ] Learn: JUnit 5 (`@Test`, assertions, lifecycle), AAA pattern
- [ ] Learn: Mockito — mock/stub/verify; unit-test a service in isolation
- [ ] Learn: `@WebMvcTest` + `MockMvc` for controller tests
- [ ] 🛠️ **PROJECT:** Write unit tests for `CartService` and a `MockMvc` test for the catalog controller.
- [ ] 🧩 **Quiz:** What's the difference between a unit test and an integration test here? What do you mock in each?

## Session 2.7 — Orders + monolith checkpoint (2 hrs)
- [ ] 🛠️ **PROJECT:** Build the **Orders** feature (place order from cart, in-memory order store, status enum).
- [ ] 🛠️ **PROJECT:** End-to-end manual test: browse → add to cart → place order.
- [ ] Review: draw your current architecture (controllers/services/repos) — 1 diagram.
- [ ] 🧩 **Quiz:** Walk through the full request lifecycle of `POST /orders` from HTTP to response.

---

# 🗄️ PHASE 3 — Persistence & Data
*Why: Real apps have real databases. Transactions & JPA internals go DEEP. (~20 hrs)*

## Session 3.1 — JPA/Hibernate foundations (2 hrs) ⭐ DEEP
- [ ] Learn: ORM concept, JPA vs Hibernate vs Spring Data, the persistence context / first-level cache
- [ ] Learn: `@Entity`, `@Id`, `@GeneratedValue`, `@Column`; entity lifecycle (transient/managed/detached/removed)
- [ ] Learn: dirty checking (why you often don't call `save()`)
- [ ] 🛠️ **PROJECT:** Turn `Product` into a JPA entity; wire an H2 DB first to see it work.
- [ ] 🧩 **Quiz:** An entity is "managed" and you change a field but never call `save()`. Does it persist? Why?

## Session 3.2 — Spring Data JPA repositories (2 hrs)
- [ ] Learn: `JpaRepository`, derived query methods, `@Query` (JPQL + native), paging & sorting
- [ ] 🛠️ **PROJECT:** Replace in-memory catalog store with a real `ProductRepository`; add pagination to `GET /products`.
- [ ] 🧩 **Quiz:** Write the derived-query method name for "find active products by category ordered by price desc".

## Session 3.3 — Relationships & fetching (2 hrs) ⭐ DEEP
- [ ] Learn: `@OneToMany`/`@ManyToOne`/`@ManyToMany`/`@OneToOne`, owning side, join columns
- [ ] Learn: lazy vs eager, the **N+1 problem**, `JOIN FETCH` / `@EntityGraph`
- [ ] 🛠️ **PROJECT:** Model `Order → OrderItems → Product`; expose an order with its items.
- [ ] 🏋️ **Exercise:** Deliberately trigger N+1, observe SQL logs, fix with a fetch join.
- [ ] 🧩 **Quiz:** Why is `EAGER` fetching on collections usually a trap?

## Session 3.4 — Transactions internals (2 hrs) ⭐ DEEP
- [ ] Learn: `@Transactional` — how Spring proxies it, propagation (`REQUIRED`, `REQUIRES_NEW`...), isolation levels
- [ ] Learn: the self-invocation gotcha (why calling a `@Transactional` method from the same class fails)
- [ ] Learn: rollback rules, read-only transactions
- [ ] 🛠️ **PROJECT:** Make "place order" transactional: deduct inventory + create order atomically; roll back on failure.
- [ ] 🧩 **Quiz:** You call `this.transactionalMethod()` internally and the transaction doesn't start. Explain exactly why.

## Session 3.5 — Postgres + migrations (2 hrs)
- [ ] Learn: swap H2 → PostgreSQL (via Docker — you know Docker), datasource config, connection pool (HikariCP)
- [ ] Learn: schema migrations with **Flyway** (versioned, repeatable)
- [ ] 🛠️ **PROJECT:** Move the app to Postgres; author Flyway migrations for all tables; seed sample data.
- [ ] 🧩 **Quiz:** Why manage schema with Flyway instead of `hibernate.ddl-auto=update` in production?

## Session 3.6 — Caching with Redis (3 hrs, weekend)
- [ ] Learn: caching concepts (cache-aside, TTL, invalidation — "one of the 2 hard problems")
- [ ] Learn: Spring Cache abstraction (`@Cacheable`/`@CacheEvict`) + Redis (Docker) as the store
- [ ] 🛠️ **PROJECT:** Cache product lookups in Redis; invalidate on update; measure the latency difference.
- [ ] 🧩 **Quiz:** Cache-aside vs write-through — describe both and a case where stale cache causes a real bug.

## Session 3.7 — Integration testing with real infra (2 hrs)
- [ ] Learn: `@DataJpaTest`, `@SpringBootTest`, **Testcontainers** (spin real Postgres/Redis in tests)
- [ ] 🛠️ **PROJECT:** Write a Testcontainers-backed integration test for the order-placement flow.
- [ ] 🧩 **Quiz:** Why is Testcontainers better than an in-memory H2 for integration tests?

---

# 🛡️ PHASE 4 — Production-Grade Backend
*Why: The difference between a toy and something a company would run. (~16 hrs)*

## Session 4.1 — Spring Security fundamentals (2 hrs) ⭐ DEEP
- [ ] Learn: the security filter chain, authentication vs authorization
- [ ] Learn: `UserDetailsService`, `PasswordEncoder` (BCrypt), securing endpoints
- [ ] 🛠️ **PROJECT:** Add users + roles (`USER`, `ADMIN`, `SELLER`); protect admin endpoints.
- [ ] 🧩 **Quiz:** Walk through what happens in the filter chain when a request hits a protected endpoint.

## Session 4.2 — JWT authentication (2 hrs)
- [ ] Learn: stateless auth, JWT structure (header/payload/signature), access vs refresh tokens
- [ ] Learn: custom JWT filter, token validation
- [ ] 🛠️ **PROJECT:** Register/login endpoints issuing JWTs; secure the API with a JWT filter; add refresh tokens.
- [ ] 🧩 **Quiz:** Why is JWT good for microservices? What's the downside of not being able to "revoke" a token?

## Session 4.3 — API design, versioning, pagination polish (2 hrs)
- [ ] Learn: REST maturity, versioning strategies, HATEOAS (awareness), consistent pagination/filtering/sorting contracts
- [ ] Learn: OpenAPI/Swagger docs (springdoc)
- [ ] 🛠️ **PROJECT:** Add Swagger UI; standardize pagination & error responses across all endpoints.
- [ ] 🧩 **Quiz:** Three ways to version an API — pros/cons of each.

## Session 4.4 — Observability (2 hrs)
- [ ] Learn: structured logging (SLF4J/Logback, MDC/correlation IDs), log levels
- [ ] Learn: Spring Boot Actuator (health, metrics, info), Micrometer → Prometheus concepts
- [ ] 🛠️ **PROJECT:** Add Actuator + health checks; add correlation-ID logging to every request.
- [ ] 🧩 **Quiz:** A request is slow in prod. Which signals (logs/metrics/traces) do you reach for and in what order?

## Session 4.5 — Cross-cutting concerns: AOP, async, scheduling (2 hrs)
- [ ] Learn: Spring AOP (`@Aspect`) — logging/timing aspect; when AOP is right
- [ ] Learn: `@Async` (thread-pool config), `@Scheduled` jobs, application events (`ApplicationEventPublisher`)
- [ ] 🛠️ **PROJECT:** Add an audit-log aspect; send order-confirmation "email" asynchronously via an application event.
- [ ] 🧩 **Quiz:** How does `@Async` relate to the proxy mechanism you learned for `@Transactional`?

## Session 4.6 — Dockerize the monolith (3 hrs, weekend)
- [ ] Learn: multi-stage Dockerfile for a Spring Boot jar, layered jars, image size
- [ ] Learn: `docker-compose` for app + Postgres + Redis (you know Docker — apply it to Java)
- [ ] 🛠️ **PROJECT:** Containerize the app; `docker-compose up` brings up the whole stack.
- [ ] 🧩 **Quiz:** Why multi-stage build? What goes in each stage?

## Session 4.7 — Monolith final hardening + review (2 hrs)
- [ ] 🛠️ **PROJECT:** Add rate-limiting or request validation polish; ensure 80%+ of core flows are tested.
- [ ] Review: architecture diagram v2; list what would break at 10× traffic (sets up microservices).
- [ ] 🧩 **Quiz:** Name 3 concrete scalability bottlenecks in your current monolith.

---

# 🧩 PHASE 5 — Microservices + Kafka ⭐⭐ CORE OF YOUR ASK
*Why: This is what you came for — scalable, event-driven, distributed systems. (~28 hrs)*

## Session 5.1 — Why microservices (and why NOT) (2 hrs)
- [ ] Learn: monolith vs microservices tradeoffs, bounded contexts, decomposition strategy, data-per-service
- [ ] Learn: the new problems microservices create (network, consistency, ops)
- [ ] 🛠️ **PROJECT:** Plan the split: **Catalog · Order · Inventory · Notification** services + shared contracts. Draw it.
- [ ] 🧩 **Quiz:** Give 2 signs a system should stay a monolith, and 2 signs it should split.

## Session 5.2 — First service split (3 hrs, weekend)
- [ ] Learn: extracting a service, its own DB, its own deployable
- [ ] 🛠️ **PROJECT:** Extract **Catalog Service** as a standalone Spring Boot app with its own Postgres.
- [ ] 🧩 **Quiz:** Why must each microservice own its database (no shared DB)?

## Session 5.3 — Synchronous comms: REST + Feign (2 hrs)
- [ ] Learn: service-to-service HTTP, OpenFeign declarative clients, `WebClient`, timeouts
- [ ] 🛠️ **PROJECT:** Extract **Order Service**; it calls Catalog via Feign to validate products.
- [ ] 🧩 **Quiz:** What are the risks of synchronous service-to-service calls (chains, latency, cascading failure)?

## Session 5.4 — Kafka fundamentals (2 hrs) ⭐ DEEP
- [ ] Learn: what Kafka is (distributed log), topics, partitions, offsets, brokers
- [ ] Learn: producers, consumers, **consumer groups**, ordering guarantees (per-partition)
- [ ] Learn: run Kafka locally via Docker
- [ ] 🏋️ **Exercise:** Produce & consume messages from a topic with the CLI; observe partitions & offsets.
- [ ] 🧩 **Quiz:** How does Kafka give you both parallelism AND ordering? What's the role of the partition key?

## Session 5.5 — Kafka with Spring: event-driven flow (3 hrs, weekend) ⭐ DEEP
- [ ] Learn: `spring-kafka`, `KafkaTemplate` producer, `@KafkaListener` consumer, serialization (JSON/Avro awareness)
- [ ] Learn: designing events (`OrderPlaced`, `InventoryReserved`, `OrderConfirmed`)
- [ ] 🛠️ **PROJECT:** Order Service publishes `OrderPlaced`; **Inventory Service** consumes it and reserves stock.
- [ ] 🧩 **Quiz:** Event notification vs event-carried-state-transfer — which are you using and why?

## Session 5.6 — Kafka delivery semantics & reliability (2 hrs) ⭐ DEEP
- [ ] Learn: at-most-once / at-least-once / exactly-once; acks, retries, **idempotent consumers**
- [ ] Learn: dead-letter topics, error handling, offset commit strategies
- [ ] 🛠️ **PROJECT:** Make the inventory consumer idempotent (dedupe by event id); add a DLT for poison messages.
- [ ] 🧩 **Quiz:** A consumer processes a message then crashes before committing the offset. What happens on restart? How do you stay correct?

## Session 5.7 — Complete the event choreography (3 hrs, weekend)
- [ ] Learn: choreography vs orchestration, the **Saga** pattern for distributed transactions
- [ ] 🛠️ **PROJECT:** Full flow via events: `OrderPlaced → InventoryReserved → OrderConfirmed → Notification sent`. Handle the failure path (out-of-stock → order cancelled) as a saga.
- [ ] 🧩 **Quiz:** Why can't you use a normal DB transaction across Order + Inventory services? How does a saga solve it?

## Session 5.8 — API Gateway + service discovery (2 hrs)
- [ ] Learn: Spring Cloud Gateway (routing, filters), service discovery (Eureka) or its k8s equivalent, config server
- [ ] 🛠️ **PROJECT:** Put all services behind a gateway; centralize routing + auth at the edge.
- [ ] 🧩 **Quiz:** What responsibilities belong at the gateway vs inside each service?

## Session 5.9 — Resilience + distributed tracing (2 hrs) ⭐ DEEP
- [ ] Learn: Resilience4j (circuit breaker, retry, bulkhead, rate limiter, timeout), fallback design
- [ ] Learn: distributed tracing (Micrometer Tracing + Zipkin/Tempo), correlation across services
- [ ] 🛠️ **PROJECT:** Add a circuit breaker to Order→Catalog calls with a fallback; wire tracing across the whole flow.
- [ ] 🧩 **Quiz:** Explain circuit breaker states (closed/open/half-open) and when each transition happens.

## Session 5.10 — Microservices integration checkpoint (2 hrs)
- [ ] 🛠️ **PROJECT:** `docker-compose` the entire stack (all services + Kafka + Postgres×N + Redis + gateway). Run the full happy path AND a failure path.
- [ ] Review: system diagram v3 with sync vs async edges marked.
- [ ] 🧩 **Quiz:** Trace one order end-to-end across every service and every Kafka topic it touches.

---

# ⚡ PHASE 6 — Reactive Capstone
*Why: You asked for Flux/WebFlux. Learn it properly, on a foundation that's already solid. (~12 hrs)*

## Session 6.1 — Reactive mindset + Reactor (2 hrs) ⭐ DEEP
- [ ] Learn: blocking vs non-blocking/async, the reactive streams spec, why & when reactive wins (and when it doesn't)
- [ ] Learn: Project Reactor — `Mono` vs `Flux`, operators (`map`/`flatMap`/`zip`/`filter`), assembly vs subscription time
- [ ] 🏋️ **Exercise:** Rewrite a small `CompletableFuture` chain (from Phase 1) as a `Mono`/`Flux` pipeline.
- [ ] 🧩 **Quiz:** Nothing happens until you subscribe — explain why, and what "cold publisher" means.

## Session 6.2 — Spring WebFlux (2 hrs)
- [ ] Learn: WebFlux vs MVC, functional & annotated endpoints, Netty event loop, `WebClient`
- [ ] 🛠️ **PROJECT:** Rebuild the **Catalog Service** (or a read-path) with WebFlux endpoints.
- [ ] 🧩 **Quiz:** Why must you never make a blocking JDBC call inside a WebFlux handler?

## Session 6.3 — Reactive data + backpressure (3 hrs, weekend) ⭐ DEEP
- [ ] Learn: R2DBC (reactive Postgres) or reactive Redis; end-to-end non-blocking
- [ ] Learn: backpressure — what it is, how Reactor handles it, `onBackpressureBuffer/Drop`
- [ ] 🛠️ **PROJECT:** Make the reactive Catalog fully non-blocking (R2DBC); stream a large product list with SSE.
- [ ] 🧩 **Quiz:** Describe a concrete backpressure scenario in your app and how the reactive stack handles it.

## Session 6.4 — Reactive vs blocking: measure & decide (2 hrs)
- [ ] Learn: load-test both versions of the service; read throughput/latency/resource usage
- [ ] 🛠️ **PROJECT:** Write a short comparison note: when you'd choose WebFlux vs MVC for THIS system.
- [ ] 🧩 **Quiz:** Give an interviewer answer: "When would you pick WebFlux over Spring MVC?"

---

# 🚢 PHASE 7 — Deployment & CI/CD
*Why: A dev who can ship is worth 10× one who can't. Get it running in the real world. (~14 hrs)*

## Session 7.1 — Containerization for prod (2 hrs)
- [ ] Learn: production Dockerfiles, image scanning, env-based config, secrets handling, healthchecks
- [ ] 🛠️ **PROJECT:** Harden all service images for prod (non-root user, small base, proper JVM flags/mem limits).
- [ ] 🧩 **Quiz:** What JVM memory flags matter inside a container and why (container-aware JVM)?

## Session 7.2 — Kubernetes basics (3 hrs, weekend) ⭐ DEEP
- [ ] Learn: pods, deployments, services, config maps, secrets, ingress (concepts + why k8s exists)
- [ ] Learn: run locally with kind/minikube or Docker Desktop k8s
- [ ] 🛠️ **PROJECT:** Deploy Catalog + Order + Kafka to a local k8s cluster; expose via ingress.
- [ ] 🧩 **Quiz:** Deployment vs Service vs Ingress — what does each do?

## Session 7.3 — CI/CD pipeline (2 hrs)
- [ ] Learn: CI/CD stages (build → test → containerize → push → deploy) — you know Git/CI, apply to Java
- [ ] Learn: GitHub Actions for a Maven/Gradle build → Docker image → registry
- [ ] 🛠️ **PROJECT:** GitHub Actions pipeline: on push, run tests + build + push image for one service.
- [ ] 🧩 **Quiz:** Where in the pipeline should tests run, and what should fail the build?

## Session 7.4 — Deploy to the cloud (3 hrs, weekend)
- [ ] Learn: pick a target (Railway/Render/Fly.io for simple, or AWS ECS/EKS for resume weight), managed Postgres/Kafka
- [ ] 🛠️ **PROJECT:** Deploy at least the Order + Catalog services + a managed DB to a real public URL.
- [ ] 🧩 **Quiz:** What changes between your `docker-compose` local setup and a real cloud deployment?

## Session 7.5 — Prod readiness + monitoring (2 hrs)
- [ ] Learn: readiness/liveness probes, graceful shutdown, log aggregation, Prometheus + Grafana dashboards
- [ ] 🛠️ **PROJECT:** Add a Grafana dashboard for key metrics (latency, error rate, Kafka lag).
- [ ] 🧩 **Quiz:** What 4 metrics would you alert on for this system? (Hint: the "golden signals".)

## Session 7.6 — Capstone polish & portfolio (2 hrs)
- [ ] 🛠️ **PROJECT:** Write a killer README: architecture diagram, tech choices & why, how to run, what you'd do next.
- [ ] 🛠️ **PROJECT:** Record a 3-min demo of the full event-driven flow.
- [ ] 🧩 **Quiz:** Do a mock system-design walkthrough of your own project out loud.

---

# 🎓 Completion Criteria
- [ ] Built ONE cohesive system: monolith → microservices → event-driven → reactive → deployed
- [ ] Kafka event-driven flow with idempotency + saga working end-to-end
- [ ] Deployed to a real cloud URL with CI/CD
- [ ] Solid test coverage (unit + integration via Testcontainers)
- [ ] Can explain: DI internals, transactions, N+1, Kafka semantics, circuit breakers, reactive tradeoffs
- [ ] Portfolio README + demo ready
- [ ] Comfortable in Java backend interviews (development + design)

---

## 🔁 The daily loop (do this every session)
1. Open ROADMAP.md → find first unchecked session.
2. Ask Claude to teach that session's theory (use C# analogies).
3. Do the 🏋️ exercise.
4. Implement the 🛠️ project slice.
5. Answer the 🧩 quiz out loud / in writing — Claude checks you.
6. Check the boxes. Commit your project code. Preview next session.

> ⚙️ **Living doc:** pace and scope will flex as your level shows. Adjust freely — just keep the build-driven, always-hands-on rhythm.
