@Service
public class StreetService {
 
    @Autowired
    private StreetRepository streetRepository;
 
    public List<Street> list() {
        return streetRepository.findAll();
    }
}