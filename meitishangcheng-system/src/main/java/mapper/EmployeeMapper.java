package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectAll();

    void add(Employee Employee);

    Employee selectById(int id);

    void update(Employee Employee);

    void delete(int id);

    void deleteByIds(@Param("ids") int[] ids);

    List<Employee> select(@Param("key") String key, @Param("value") String value);

    List<Employee> selectLimit(@Param("begin")int begin,@Param("size")int size);

    int selectCount();
}
