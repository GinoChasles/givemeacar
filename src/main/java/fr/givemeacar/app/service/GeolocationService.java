@Service
public class GeolocationService {
 
    @Autowired
    private GeolocationRepository geolocationRepository;
 
    public List<Geolocation> list() {
        return geolocationRepository.findAll();
    }
}