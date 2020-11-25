@Service
public class AddressService {
 
    @Autowired
    private AddressRepository addressRepository;
 
    public List<Address> list() {
        return addressRepository.findAll();
    }
}