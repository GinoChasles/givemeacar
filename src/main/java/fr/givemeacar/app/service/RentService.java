@Service
public class RentService {
 
    @Autowired
    private RentRepository rentRepository;
 
    public List<Rent> list() {
        return rentRepository.findAll();
    }
}