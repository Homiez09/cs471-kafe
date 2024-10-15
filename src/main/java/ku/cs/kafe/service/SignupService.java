//6510405750 Phumrapee Soenvanichakul
package ku.cs.kafe.service;

import ku.cs.kafe.entity.Member;
import ku.cs.kafe.repository.MemberRepository;
import ku.cs.kafe.request.SignupRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username){
        return repository.findByUsername(username) == null;
    }

    public void createUser(SignupRequest user) {
        Member record = modelMapper.map(user, Member.class);
        record.setName(user.getName());
        record.setUsername(user.getUsername());
        record.setRole("ROLE_USER");


        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);


        repository.save(record);
    }


    public Member getUser(String username) {
        return repository.findByUsername(username);
    }

}
