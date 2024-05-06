package com.todotic.contactlistapi.service;

import com.todotic.contactlistapi.dto.ContactDTO;
import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.exception.ResourceNotException;
import com.todotic.contactlistapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }
    public  Contact findById( Integer id){
        return contactRepository
                .findById(id)
                .orElseThrow(ResourceNotException::new);
    }
    public Contact create( ContactDTO contactDTO){
        Contact contact = mapper.map(contactDTO,Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);

    }
    public Contact update( Integer id, ContactDTO contactDTO){
        Contact contactFromFb = findById(id);
        mapper.map(contactDTO,contactFromFb);
        return contactRepository.save(contactFromFb);
    }
    public void delete( Integer id){
        Contact contactFromFb = findById(id);

        contactRepository.delete(contactFromFb);
    }
}
