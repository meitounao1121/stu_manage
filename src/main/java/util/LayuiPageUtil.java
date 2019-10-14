package util;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LayuiPageUtil {
    Integer count;
    List<?> data;
    public LayuiPageUtil(Page<?> page) {
        this.data = page.getRecords();
        this.count = Math.toIntExact(page.getTotal());
    }
}
