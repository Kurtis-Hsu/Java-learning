package cn.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.example.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper extends BaseMapper<Demo>
{
}
