@Service
public class UserStatusService {
 
    @Autowired
    private UserStatusRepository userStatusRepository;
 
    public List<UserStatus> list() {
        return userStatusRepository.findAll();
    }
}