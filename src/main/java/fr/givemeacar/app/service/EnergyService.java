@Service
public class EnergyService {
 
    @Autowired
    private EnergyRepository energyRepository;
 
    public List<Energy> list() {
        return energyRepository.findAll();
    }
}