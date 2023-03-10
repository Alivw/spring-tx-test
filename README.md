# 关于spring @Transaction

## 异常处理

- 默认情况下，业务方法抛出 unckecked Exception 

  ```shell
  curl http://localhost:8080/tx/ex/rollback/unchecked
  ```

  ![image-20230310101143387](README/img/image-20230310101143387.png)

  能够正确捕获异常，并进行回滚

- 默认情况下，业务方法抛出 checked Exception 

  ```shell
  curl http://localhost:8080/tx/ex/rollback/checked
  ```

  ![image-20230310102211002](README/img/image-20230310102211002.png)

  ![image-20230310102226798](README/img/image-20230310102226798.png)

  成功的记录数4，异常数1，但是数据库却有5条数据，说明对于 checked 异常，并不能回滚

- @Transactional(rollbackFor = Exception.class)  业务方法抛出 checked Exception 

  ```shell
  curl http://localhost:8080/tx/ex/rollback/checked/for
  ```

  ![image-20230310102758413](README/img/image-20230310102758413.png)

  出现了异常，但是能够正确回滚