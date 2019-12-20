package com.hk.Service;

import com.hk.po.College;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SchoolService {
    College insCollege(College college);
    College selCollege(Long id);
    College updCollege(Long id,College college);
    void delCollege(Long id);
    //分页查询
    Page<College> listCollege(Pageable pageable);

}
