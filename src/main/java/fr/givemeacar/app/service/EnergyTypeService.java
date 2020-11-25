@Service
public class EnergyTypeService {
 
    @Autowired
    private EnergyTypeRepository energyTypeRepository;
 
    public List<EnergyType> list() {
        return energyTypeRepository.findAll();
    }
}