@Service
public class CarService {
 
    @Autowired
    private CarRepository carRepository;
 
    public List<Car> list() {
        return carRepository.findAll();
    }
}