@Service
public class AgencyService {
 
    @Autowired
    private AgencyRepository agencyRepository;
 
    public List<Agency> list() {
        return agencyRepository.findAll();
    }
}