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
- API get All Todo work with paging: 
    - URL: .../api/get-all-work
    - Method: POST
    - Body: 
      ```
      {
          "page": 1, //page value, from: 0,1,2,...
          "size": 5, //number record each page
          "field_sort": "name" //field sort by: id, name, start, end, status
       }
      ```
- API create new Todo work: api/create-new-work
    - URL: .../api/create-new-work
    - Method: POST
    - Body: 
      ```
      {
          "work_name": "work 8", //name
          "starting_date": "01/02/2021 12:30:00", //time, format: dd/MM/yyyy HH:mm:ss
          "ending_date": "10/02/2021 12:30:00", //time, format: dd/MM/yyyy HH:mm:ss
          "status": 1 //Status: 1 2 3
       }
      ```
- API update Todo work: api/update-work
    - URL: .../api/update-work
    - Method: POST
    - Body: 
      ```
      {
           "work_name": "work 8", //name
           "starting_date": "01/02/2021 12:30:00", //time, format: dd/MM/yyyy HH:mm:ss
           "ending_date": "10/02/2021 12:30:00", //time, format: dd/MM/yyyy HH:mm:ss
           "status": 1 //Status: 1 2 3
       }
      ```
- API delete Todo work by ID: api/delete-work/{id}
    - URL: .../api/delete-work/{id}
    - Method: DELETE
    - Body: none

