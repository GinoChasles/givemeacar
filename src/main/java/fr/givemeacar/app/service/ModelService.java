@Service
public class ModelService {
 
    @Autowired
    private ModelRepository modelRepository;
 
    public List<Model> list() {
        return modelRepository.findAll();
    }
}