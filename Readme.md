**Install**
- MySQL 5.7
- Java 8, Spring Boot 2.2.1
- IDE: IntelliJ
- Git
- Maven + Hibernate + Lombok

**Create DB**
```
spring.datasource.url = jdbc:mysql://localhost:3306/to_do_db?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username = root
spring.datasource.password = 1234
```
| Field  |  Type | Null  | Key  | Extra  |
|---|---|---|---|---|
|  id |  bigint(20) | NO  |  PRI |  auto_increment |
|  name |  varchar(255) | YES  |   |   |
|  start | long  | YES  |   |   |
|  end |  long |  YES |   |   |
|  status |  int(11) |  YES |   |   |

**Exception**
- Validate Null/Blank

**Model**
- RequestModel
- ResponseModel
- Entity

**Repository**
- Provide method: save, update, find, findById,...

**Controller**
- API get All Todo work: api/get-all-work
- API create new Todo work: api/create-new-work
- API get Todo work by ID: api/get-work/{id}
- API update Todo work: api/update-work
- API delete Todo work by ID: api/delete-work/{id}

