package com.revature.ecomm.Merch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MerchServlet {
    private MerchService merchService;
    public MerchServlet(MerchService merchService){
        this.merchService = merchService;
    }
    @PostMapping("/newMerch")
    public ResponseEntity<Merch> createMerch(@RequestBody Merch newMerch){
        Merch merch = merchService.create(newMerch);
        return new ResponseEntity<>(merch, HttpStatus.CREATED);
    }
    @GetMapping("/findMerch")
    public ResponseEntity<List> findAllMerch(){
        return new ResponseEntity<>(merchService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/updateMerch")
    public ResponseEntity<Merch> updateMerch(@RequestBody Merch merch){
        Merch updatedMerch = merchService.update(merch);
        return new ResponseEntity<>(updatedMerch, HttpStatus.OK);
    }
}
