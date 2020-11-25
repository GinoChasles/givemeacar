@Service
public class ClientService {
 
    @Autowired
    private ClientRepository clientRepository;
 
    public List<Client> list() {
        return clientRepository.findAll();
    }
}