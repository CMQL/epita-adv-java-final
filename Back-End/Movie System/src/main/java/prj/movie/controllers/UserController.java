package prj.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.movie.DTOs.UserDTO;
import prj.movie.data.Role;
import prj.movie.data.SeenMovie;
import prj.movie.data.User;
import prj.movie.services.impl.MovieServiceDAO;
import prj.movie.services.impl.RoleServiceDAO;
import prj.movie.services.impl.SeenMovieServiceDAO;
import prj.movie.services.impl.UserServiceDAO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController
{
    @Autowired
    UserServiceDAO userServiceDAO;

    @Autowired
    SeenMovieServiceDAO seenMovieServiceDAO;

    @Autowired
    RoleServiceDAO roleServiceDAO;

    @GetMapping("/{movieid}")
    public ResponseEntity userSeenMovie(@PathVariable("movieid")String mID)
    {
        List<User> userList= userServiceDAO.getAll();
        List<SeenMovie> seenMovieList=seenMovieServiceDAO.getAll();
        List<Role> roleList=roleServiceDAO.getAll();

        List<SeenMovie> possibleMovie = new ArrayList<SeenMovie>();
        List<User> possibleUser =new ArrayList<User>();

        for (SeenMovie s:seenMovieList) {
            if(s.getMovieid().contains(mID))
            {
                possibleMovie.add(s);
            }
        }
        for (User u:userList) {
            if (possibleMovie.contains(u.getSeenMovie()))
            {
                possibleUser.add(u);
            }
        }
        List<UserDTO> userDTOList=new ArrayList<UserDTO>();
        for (User u:possibleUser) {
            UserDTO userDTO=new UserDTO();
            userDTO.setUserid(u.getUserid());
            userDTO.setUsername(u.getUsername());
            for (Role r:roleList) {
                if (u.equals(r.getUser()))
                {
                    userDTO.setRole(r.getName());
                }
            }
        }
        return ResponseEntity.status(200).body(userDTOList);

    }
}
