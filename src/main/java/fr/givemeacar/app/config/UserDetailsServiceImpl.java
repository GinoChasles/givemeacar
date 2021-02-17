package fr.givemeacar.app.config;

import fr.givemeacar.app.model.User;
import fr.givemeacar.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

/**
 * CLasse permettant de retourner une instance de MyUserDetails en cherchant l'utilisateur par son username dans la
 * base de données
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    //le repository permettant la recherche de l'utilisateur
    @Autowired
    private UserRepository userRepository;

    //l'utilisateur trouvé
    private User user;

    /**
     * Cherche un utilisateur en bases de données et en retourne un UserDetails ou déclenche un
     * UsernameNotFoundException
     * @param username le username de l'utilisateur à chercher en base de données
     * @return une instance MyUserDetails contenant l'utilisateur trouvé en base de données
     * @throws UsernameNotFoundException L'exception déclenchée si aucun utilisateur n'est trouvé en base de données
     */
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {

        user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }
}