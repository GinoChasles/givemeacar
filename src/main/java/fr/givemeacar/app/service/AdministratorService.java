@Service
public class AdministratorService {
 
    @Autowired
    private AdministratorRepository administratorRepository;
 
    public List<Administrator> list() {
        return administratorRepository.findAll();
    }
}