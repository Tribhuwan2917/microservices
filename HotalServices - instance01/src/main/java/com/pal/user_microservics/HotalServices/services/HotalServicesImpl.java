package com.pal.user_microservics.HotalServices.services;

import com.pal.user_microservics.HotalServices.constants.HotalExceptionMessage;
import com.pal.user_microservics.HotalServices.constants.HttpResponseMessage;
import com.pal.user_microservics.HotalServices.entity.Hotal;
import com.pal.user_microservics.HotalServices.exception.HotalAlreadyExistsException;
import com.pal.user_microservics.HotalServices.exception.HotalNotFoundException;
import com.pal.user_microservics.HotalServices.repository.HotalRepository;
import com.pal.user_microservics.HotalServices.services.request.HotalRequest;
import com.pal.user_microservics.HotalServices.services.response.HotalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HotalServicesImpl implements HotalServices{
    @Autowired
    private HotalRepository hotalRepository;
    @Override
    public String createHotal(HotalRequest hotalRequest) {
     if(hotalRepository.existsById(hotalRequest.getHotalId()))
     {
         throw new HotalAlreadyExistsException(HotalExceptionMessage.HOTAL_ALREADY_EXISTS);
     }else {
         Hotal hotal=Hotal.builder().hotalAbout(hotalRequest.getHotalAbout()).hotalLocation(hotalRequest.getHotalLocation()).hotalName(hotalRequest.getHotalName()).hotalId(hotalRequest.getHotalId()).build();
         hotalRepository.save(hotal);
         return HttpResponseMessage.HOTAL_CREATD+hotalRequest.getHotalId();
     }
    }

    @Override
    public HotalResponse getHotalById(String hotalId) {
       if (hotalRepository.existsById(hotalId))
       {
           Hotal hotal=hotalRepository.findById(hotalId).get();
           HotalResponse hotalResponse=HotalResponse.builder().hotalAbout(hotal.getHotalAbout()).hotalLocation(hotal.getHotalLocation()).hotalName(hotal.getHotalName()).hotalId(hotal.getHotalId()).build();
           return hotalResponse;
       }
        throw new HotalNotFoundException(HotalExceptionMessage.HOTAL_NOT_FOUND);
    }

    @Override
    public List<HotalResponse> getAllHotal() {
        List<Hotal> hotalList=hotalRepository.findAll();
        List<HotalResponse> hotalResponseList=new ArrayList<>();
        if(hotalList.isEmpty())
        {
           throw new HotalNotFoundException(HotalExceptionMessage.HOTAL_EMPTY_LIST);
        }else {
            for (Hotal hotal:hotalList)
            {
                HotalResponse hotalResponse=HotalResponse.builder().hotalAbout(hotal.getHotalAbout()).hotalLocation(hotal.getHotalLocation()).hotalName(hotal.getHotalName()).hotalId(hotal.getHotalId()).build();
                hotalResponseList.add(hotalResponse);
            }
        }
        return hotalResponseList;
    }

    @Override
    public String deleteHotal(String hotalId) {
        if(hotalRepository.existsById(hotalId))
        {
            hotalRepository.deleteById(hotalId);
            return HttpResponseMessage.HOTAL_DELETED_BY_ID+hotalId;

        }
       throw new HotalNotFoundException(HotalExceptionMessage.HOTAL_NOT_FOUND);
    }

    @Override
    public String updateHotal(HotalRequest hotalRequest) {
        if(hotalRepository.existsById(hotalRequest.getHotalId()))
        {
            Hotal hotal=Hotal.builder().hotalLocation(hotalRequest.getHotalLocation()).hotalName(hotalRequest.getHotalName()).hotalAbout(hotalRequest.getHotalAbout()).hotalId(hotalRequest.getHotalId()).build();
            hotalRepository.save(hotal);
            return HttpResponseMessage.HOTAL_UPDATE_BY_ID+hotalRequest.getHotalId();
        }
       throw new HotalNotFoundException(HotalExceptionMessage.HOTAL_NOT_FOUND);
    }
}
