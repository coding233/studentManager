package com.hk.Service;

import com.hk.Dao.SchoolRepository;
import com.hk.po.College;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolRepository schoolRepository;

    @Transactional
    @Override
    public College insCollege(College college) {
        return schoolRepository.save(college);
    }

    @Transactional
    @Override
    public College selCollege(Long id) {
        return schoolRepository.findOne(id);
    }

    @Transactional
    @Override
    public College updCollege(Long id,College college) {
        College c=schoolRepository.findOne(id);
        if(c==null){
            System.out.println("莫得这个值");
        }
        BeanUtils.copyProperties(college,c);
        return schoolRepository.save(c);
    }

    @Transactional
    @Override
    public void delCollege(Long id) {
        schoolRepository.delete(id);
    }

    @Override
    public Page<College> listCollege(Pageable pageable) {
        return schoolRepository.findAll(pageable);
    }
}
