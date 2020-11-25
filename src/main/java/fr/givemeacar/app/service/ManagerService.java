@Service
public class ManagerService {
 
    @Autowired
    private ManagerRepository managerRepository;
 
    public List<Manager> list() {
        return managerRepository.findAll();
    }
}