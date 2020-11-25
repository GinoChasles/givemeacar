@Service
public class StreetTypeService {
 
    @Autowired
    private StreetTypeRepository streetTypeRepository;
 
    public List<StreetType> list() {
        return streetTypeRepository.findAll();
    }
}