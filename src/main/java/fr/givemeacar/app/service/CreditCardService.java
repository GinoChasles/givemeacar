@Service
public class CreditCardService {
 
    @Autowired
    private CreditCardRepository creditCardRepository;
 
    public List<CreditCard> list() {
        return creditCardRepository.findAll();
    }
}