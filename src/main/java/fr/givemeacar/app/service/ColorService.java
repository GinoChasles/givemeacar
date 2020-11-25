@Service
public class ColorService {
 
    @Autowired
    private ColorRepository colorRepository;
 
    public List<Color> list() {
        return colorRepository.findAll();
    }
}