@Service
public class BrandService {
 
    @Autowired
    private BrandRepository brandRepository;
 
    public List<Brand> list() {
        return brandRepository.findAll();
    }
}