@Service
public class BillService {
 
    @Autowired
    private BillRepository billRepository;
 
    public List<Bill> list() {
        return billRepository.findAll();
    }
}