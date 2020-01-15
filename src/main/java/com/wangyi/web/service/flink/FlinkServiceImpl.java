package com.wangyi.web.service.flink;

import com.github.pagehelper.PageHelper;
import com.wangyi.web.dao.FlinkMapper;
import com.wangyi.web.pojo.Flink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName FlinkServiceImpl
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1212:11
 * @Version 1.0
 **/
@Service
public class FlinkServiceImpl implements FlinkService {
    @Autowired
    private FlinkMapper flinkMapper;
    @Override
    public List<Flink> selAllFlink(int pageNum) {
        PageHelper.startPage(pageNum, 5);
        return flinkMapper.selFlink(new Flink());
    }

    @Override
    public Flink selFlinkByID(Flink flink) {
        List<Flink> flinks = flinkMapper.selFlink(flink);
        if(flinks.size()!=0){
            return flinks.get(0);
        }
        return new Flink();
    }

    @Override
    public int saveFlink(Flink flink) {
        if(flink.getId()==null){
            return flinkMapper.insFlink(flink);
        }else{
            return flinkMapper.updFlink(flink);
        }
    }

    @Override
    public int delFilnk(int id) {
        return flinkMapper.delFlink(id);
    }

    @Override
    public int delByList(Integer[] list) {
        for (int i :
                list) {
            flinkMapper.delFlink(i);
        }
        return list.length;
    }
}
