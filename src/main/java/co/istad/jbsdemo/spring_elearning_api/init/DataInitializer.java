package co.istad.jbsdemo.spring_elearning_api.init;



import co.istad.jbsdemo.spring_elearning_api.feature.city.CityRepository;
import co.istad.jbsdemo.spring_elearning_api.feature.country.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//populate data (role with some data)
@Component
@RequiredArgsConstructor
public class DataInitializer {
    //? Sample to start with
private final CountryRepository countryRepository;
private final CityRepository cityRepository;
//    private final RoleRepository roleRepository;
//    private final AccountTypeRepository accountTypeRepository;
//
//    @PostConstruct
//    void roleInit() {
//        List<String> roles = List.of("Admin", "Stuff", "User");
//        if (roleRepository.findAll().isEmpty()) {
//            for (String role : roles) {
//                Role roleObj = new Role();
//                roleObj.setName(role);
//                roleRepository.save(roleObj);
//            }
//        }
//    }
//
//    @PostConstruct
//    void accountTypesInit() {
//        List<AccountType> accountTypes = new ArrayList<>() {{
//            add(new AccountType().setName("Savings").setDescription("This is the type of account that you gain interest when you save your money in the bank"));
//
//            add(new AccountType().setName("Payrolls").setDescription("This is account to get paid by company monthly"));
//            add(new AccountType().setName("Card").setDescription("Allow you to create different card for persernal uses!"));
//        }};
//        if (accountTypeRepository.findAll().isEmpty()) {
//            accountTypeRepository.saveAll(accountTypes);
//        }
//    }

//call insertCountries from repository
    @PostConstruct
    void insertCountries() {
        // check if countries already have data don't insert
        if (countryRepository.findAll().isEmpty()) {
            countryRepository.insertCountries();
        }
    }

    String[][] cityCountryDataArray={
            {"Ţāqchah Khānah", "AF"}, {"Khandūd", "AF"}, {"Bagrāmī", "AF"}, {"Ghazni", "AF"}, {"Qal‘ah-ye Kūf", "AF"}, {"Sōzmah Qal‘ah", "AF"}, {"Khulm", "AF"}, {"Tōrmay", "AF"}, {"Būrkah", "AF"}, {"Khadīr", "AF"}, {"Liberta", "AG"}, {"Shirgjan", "AL"}, {"Wulêswālī Bihsūd", "AF"}, {"Mazār-e Sharīf", "AF"}, {"Leshnjë", "AL"}, {"Kalafgān", "AF"}, {"Quchanghī", "AF"}, {"Maydanshakhr", "AF"}, {"Rūdbār", "AF"}, {"‘Alāqahdārī Yōsuf Khēl", "AF"}, {"Muzayri‘", "AE"}, {"Jānī Khēl", "AF"}, {"Mingajik", "AF"}, {"Khūgyāṉī", "AF"}, {"Progër", "AL"}, {"Fayzabad", "AF"}, {"Narang", "AF"}, {"Anār Darah", "AF"}, {"la Massana", "AD"}, {"Dowlat Shāh", "AF"}, {"Kishk-e Nakhūd", "AF"}, {"Canillo", "AD"}, {"Dowlatyār", "AF"}, {"Andorra la Vella", "AD"}, {"Maymana", "AF"}, {"Arinsal", "AD"}, {"Sar-e Pul", "AF"}, {"Lashkar Gāh", "AF"}, {"Zindah Jān", "AF"}, {"Yaḩyá Khēl", "AF"}, {"Kolsh", "AL"}, {"Bal Chirāgh", "AF"}, {"Voskopojë", "AL"}, {"Barg-e Matāl", "AF"}, {"Kushk-e Kuhnah", "AF"}, {"Ashkāsham", "AF"}, {"Zaranj", "AF"}, {"Māṉōgay", "AF"}, {"Karukh", "AF"}, {"Khinjān", "AF"}, {"Ōmnah", "AF"}, {"Kushkak", "AF"}, {"Stêr Giyān", "AF"}, {"Khalifah A City", "AE"}, {"Bala Murghab", "AF"}, {"Ḩāfiz̧ Moghul", "AF"}, {"Dehī", "AF"}, {"Topojan", "AL"}, {"Wāshēr", "AF"}, {"Charkh", "AF"}, {"Mūsá Qal‘ah", "AF"}, {"Miras", "AL"}, {"Kushovë", "AL"}, {"Trebisht-Muçinë", "AL"}, {"Qāshqāl", "AF"}, {"El Tarter", "AD"}, {"Bahārak", "AF"}, {"Tīr Pul", "AF"}, {"Abu Dhabi", "AE"}, {"Poliçan", "AL"}, {"Chahār Bāgh", "AF"}, {"Deh-e Şalāḩ", "AF"}, {"Bāzār-e Tashkān", "AF"}, {"Bāzār-e Yakāwlang", "AF"}, {"Ajman City", "AE"}, {"Proptisht", "AL"}, {"Delvinë", "AL"}, {"Baghlān", "AF"}, {"Mollaj", "AL"}, {"Qal‘ah-ye Na‘īm", "AF"}, {"Macukull", "AL"}, {"Trebinjë", "AL"}, {"Saint John’s", "AG"}, {"Sangīn", "AF"}, {"Gramsh", "AL"}, {"Jalrēz", "AF"}, {"Zīrakī", "AF"}, {"Vendresha e Vogël", "AL"}, {"Dwah Manḏay", "AF"}, {"Librazhd", "AL"}, {"Gjinkar", "AL"}, {"Kthella e Epërme", "AL"}, {"Polis-Gostimë", "AL"}, {"Zōr Kōṯ", "AF"}, {"Lab-Sar", "AF"}, {"Kastriot", "AL"}, {"Qafëmal", "AL"}, {"Ḩukūmat-e Shīnkaī", "AF"}, {"Suç", "AL"}, {"Voskop", "AL"}, {"Chandal Bā’ī", "AF"}, {"Al Wiqan", "AE"}, {"Dasht-e Qal‘ah", "AF"}, {"Muḩammad Āghah Wuluswālī", "AF"}, {"Jalālābād", "AF"}, {"Livadhja", "AL"}, {"North Hill Village", "AI"}, {"‘Alāqahdārī Gēlān", "AF"}, {"South Hill Village", "AI"}, {"Khawr Fakkān", "AE"}, {"Tukzār", "AF"}, {"Tregan", "AL"}, {"Zavalinë", "AL"}, {"Qal‘ah-ye Fārsī", "AF"}, {"Khinj", "AF"}, {"Guz̄arah", "AF"}, {"Kukur", "AL"}, {"Melan", "AL"}, {"East End Village", "AI"}, {"Dāngām", "AF"}, {"Sant Julià de Lòria", "AD"}, {"‘Alāqahdārī-ye Almār", "AF"}, {"Kanḏay", "AF"}, {"Kuran wa Munjan", "AF"}, {"Alah Sāy", "AF"}, {"Pasāband", "AF"}, {"Zīṟūk ‘Alāqahdārī", "AF"}, {"Dibba Al-Fujairah", "AE"}, {"Pishaj", "AL"}, {"Adraskan", "AF"}, {"Karbōṟī", "AF"}, {"Pārūn", "AF"}, {"Jawand", "AF"}, {"Pogradec", "AL"}, {"Mīray", "AF"}, {"Injīl", "AF"}, {"Zamtō Kêlay", "AF"}, {"Deh-e Now", "AF"}, {"Zerqan", "AL"}, {"Surroj", "AL"}, {"Chākarān", "AF"}, {"Kunduz", "AF"}, {"Sarfirāz Kalā", "AF"}, {"Potters Village", "AG"}, {"Kaz̲h̲ah", "AF"}, {"Khamyāb", "AF"}, {"Golaj", "AL"}, {"Orenjë", "AL"}, {"Pul-e Sangī", "AF"}, {"Imām Şāḩib", "AF"}, {"Island Harbour", "AI"}, {"Sukë", "AL"}, {"Xarrë", "AL"}, {"Dibba Al-Hisn", "AE"}, {"Surkh Bilandī", "AF"}, {"Chimtāl", "AF"}, {"Fayrōz Kōh", "AF"}, {"Khanabad", "AF"}, {"Ghormach", "AF"}, {"Charikar", "AF"}, {"Chisht-e Sharīf", "AF"}, {"‘Alīābād", "AF"}, {"Sang-e Māshah", "AF"}, {"Hoçisht", "AL"}, {"Maliq", "AL"}, {"Shushicë", "AL"}, {"Klos", "AL"}, {"Mollas", "AL"}, {"Steblevë", "AL"}, {"‘Alāqahdārī Saṟōbī", "AF"}, {"Gōmal Kêlay", "AF"}, {"Qal‘ah-ye Kuhnah", "AF"}, {"Hotolisht", "AL"}, {"Dū Laīnah", "AF"}, {"Rū-ye Sang", "AF"}, {"Al Fujairah City", "AE"}, {"Konispol", "AL"}, {"Khāsh", "AF"}, {"Iballë", "AL"}, {"Kodovjat", "AL"}, {"Kirāmān", "AF"}, {"Chīras", "AF"}, {"Rabāţ-e Sangī-ye Pā’īn", "AF"}, {"Këlcyrë", "AL"}, {"Urgun", "AF"}, {"Zarghūn Shahr", "AF"}, {"Farrington", "AI"}, {"Korçë", "AL"}, {"Pul-e ‘Alam", "AF"}, {"Al Manāmah", "AE"}, {"Bāgh-e Maīdān", "AF"}, {"Xibër-Murrizë", "AL"}, {"Musaffah", "AE"}, {"Sult", "AL"}, {"Dūāb", "AF"}, {"Qurghān", "AF"}, {"Shënmëri", "AL"}, {"Spīn Bōldak", "AF"}, {"Shaykh Amīr Kêlay", "AF"}, {"Velçan", "AL"}, {"Zall-Dardhë", "AL"}, {"Taloqan", "AF"}, {"Zaṟah Sharan", "AF"}, {"Wuluswālī ‘Alīngār", "AF"}, {"Leskovik", "AL"}, {"Khākirān", "AF"}, {"Siyāhgird", "AF"}, {"Jabal os Saraj", "AF"}, {"Dahan-e Jarf", "AF"}, {"Sandy Hill", "AI"}, {"Mehtar Lām", "AF"}, {"Sangar Sarāy", "AF"}, {"Asadābād", "AF"}, {"Qarchī Gak", "AF"}, {"Skënderbegas", "AL"}, {"Gōshtah", "AF"}, {"Bani Yas City", "AE"}, {"Qādis", "AF"}, {"Ostreni i Math", "AL"}, {"Deh Khwāhān", "AF"}, {"Khān Neshīn", "AF"}, {"Lenias", "AL"}, {"Vërtop", "AL"}, {"Ordino", "AD"}, {"Larkird", "AF"}, {"Āqchah", "AF"}, {"Ras Al Khaimah City", "AE"}, {"Libonik", "AL"}, {"Chakaray", "AF"}, {"Orosh", "AL"}, {"Al Ain City", "AE"}, {"Banū", "AF"}, {"Sarandë", "AL"}, {"Qereshnik", "AL"}, {"Zurmat", "AF"}, {"Panjāb", "AF"}, {"George Hill", "AI"}, {"Qukës-Skënderbe", "AL"}, {"West End Village", "AI"}, {"Aībak", "AF"}, {"Përrenjas", "AL"}, {"Sar Chakān", "AF"}, {"‘Alī Shēr ‘Alāqahdārī", "AF"}, {"Gostimë", "AL"}, {"Selishtë", "AL"}, {"Mesopotam", "AL"}, {"Mīrān", "AF"}, {"Pirg", "AL"}, {"Dê Nārkhēl Kêlay", "AF"}, {"Codrington", "AG"}, {"Dowr-e Rabāţ", "AF"}, {"Skore", "AL"}, {"Āfāqī", "AF"}, {"Markaz-e Woluswalī-ye Āchīn", "AF"}, {"Jurm", "AF"}, {"Bati", "AF"}, {"Uruzgān", "AF"}, {"Blowing Point Village", "AI"}, {"March", "AF"}, {"Farah", "AF"}, {"Buçimas", "AL"}, {"Langar", "AF"}, {"Zaybāk", "AF"}, {"Ḩukūmat-e Nād ‘Alī", "AF"}, {"Sandy Ground Village", "AI"}, {"Maqellarë", "AL"}, {"Tepelenë", "AL"}, {"Qarāwul", "AF"}, {"Rāẕay Balochi", "AF"}, {"Peshkopi", "AL"}, {"Bāmyān", "AF"}, {"Markaz-e Ḩukūmat-e Darwēshān", "AF"}, {"Finiq", "AL"}, {"Qestorat", "AL"}, {"Tītān", "AF"}, {"les Escaldes", "AD"}, {"Muhmand Dara", "AF"}, {"Wuṯahpūr", "AF"}, {"Qal‘ah-ye Shāhī", "AF"}, {"Kandahār", "AF"}, {"Lāsh", "AF"}, {"‘Alāqahdārī Aṯghar", "AF"}, {"Muqêr", "AF"}, {"Nāṟay", "AF"}, {"Chāh Āb", "AF"}, {"Ḩāfiz̧ān", "AF"}, {"Maşfūţ", "AE"}, {"Balkh", "AF"}, {"Now Dahānak", "AF"}, {"Farkhār", "AF"}, {"Chahār Qal‘ah", "AF"}, {"Andkhōy", "AF"}, {"Novoselë", "AL"}, {"Chahār Burj", "AF"}, {"Ḏanḏar", "AF"}, {"‘Alāqahdārī Dīshū", "AF"}, {"Yangī Qal‘ah", "AF"}, {"Lis", "AL"}, {"Nūsay", "AF"}, {"Chinār", "AF"}, {"Sar Kāṉī", "AF"}, {"Murbaḩ", "AE"}, {"Khōshāmand", "AF"}, {"Zapod", "AL"}, {"Qarghah’ī", "AF"}, {"Markat", "AL"}, {"Qaranghū Tōghaī", "AF"}, {"Krumë", "AL"}, {"Kalis", "AL"}, {"Vergo", "AL"}, {"Sang-e Chārak", "AF"}, {"Petran", "AL"}, {"Kukës", "AL"}, {"Bāzār-e Tālah", "AF"}, {"Zall-Reç", "AL"}, {"Shtiqën", "AL"}, {"Ḩājī Khēl", "AF"}, {"’Unābah", "AF"}, {"Sulţānpūr-e ‘Ulyā", "AF"}, {"North Side", "AI"}, {"Ārt Khwājah", "AF"}, {"Chowṉêy", "AF"}, {"Odrie", "AL"}, {"Lunik", "AL"}, {"Bulōlah", "AF"}, {"Rāmak", "AF"}, {"Tarinkot", "AF"}, {"Baraki Barak", "AF"}, {"Salām Khēl", "AF"}, {"Stravaj", "AL"}, {"Qalāt", "AF"}, {"Darzāb", "AF"}, {"Darqad", "AF"}, {"Tūlak", "AF"}, {"Tagāw-Bāy", "AF"}, {"Shērwānī-ye Bālā", "AF"}, {"Ar Ruways", "AE"}, {"Labinot-Fushë", "AL"}, {"Llugaj", "AL"}, {"Dōshī", "AF"}, {"Mīr Bachah Kōṯ", "AF"}, {"Fayẕābād", "AF"}, {"Maīdān Khūlah", "AF"}, {"Ḩukūmatī Azrah", "AF"}, {"Shibirghān", "AF"}, {"Kalān Deh", "AF"}, {"Gjinar", "AL"}, {"Qaram Qōl", "AF"}, {"Sar-e Tayghān", "AF"}, {"Pas Pul", "AF"}, {"‘Alī Khēl", "AF"}, {"Ōbêh", "AF"}, {"Mīzān ‘Alāqahdārī", "AF"}, {"Al Shamkhah City", "AE"}, {"Istālif", "AF"}, {"Udënisht", "AL"}, {"Sllovë", "AL"}, {"Spērah", "AF"}, {"Poroçan", "AL"}, {"Qarah Bāgh", "AF"}, {"Khōshī", "AF"}, {"Faīẕābād", "AF"}, {"Reef Al Fujairah City", "AE"}, {"Pasnay", "AF"}, {"Potom", "AL"}, {"Saraqinishtë", "AL"}, {"Kabul", "AF"}, {"Eslam Qaleh", "AF"}, {"Khwājah Dū Kōh", "AF"}, {"Nīlī", "AF"}, {"Taywarah", "AF"}, {"Tagāb", "AF"}, {"Dasht-e Archī", "AF"}, {"Zayed City", "AE"}, {"Āq Kupruk", "AF"}, {"Sharjah", "AE"}, {"Nayak", "AF"}, {"Shishtavec", "AL"}, {"Nahrīn", "AF"}, {"Gjirokastër", "AL"}, {"Kardhiq", "AL"}, {"Tomin", "AL"}, {"Ibrāhīm Khān", "AF"}, {"Umm Al Quwain City", "AE"}, {"Aliko", "AL"}, {"Now Zād", "AF"}, {"Vithkuq", "AL"}, {"Pul-e Ḩişār", "AF"}, {"Kurbnesh", "AL"}, {"Qarqīn", "AF"}, {"Tsowkêy", "AF"}, {"Khwājah Ghār", "AF"}, {"S̲h̲ēwah", "AF"}, {"Markaz-e Ḩukūmat-e Sulţān-e Bakwāh", "AF"}, {"Labinot-Mal", "AL"}, {"Sang Atesh", "AF"}, {"Sidqābād", "AF"}, {"Shëngjin", "AL"}, {"Ghulām ‘Alī", "AF"}, {"Mardīān", "AF"}, {"Rajcë", "AL"}, {"Piggotts", "AG"}, {"Khōst", "AF"}, {"Bāzārak", "AF"}, {"Ghurayd Gharamē", "AF"}, {"Khānaqāh", "AF"}, {"Dū Qal‘ah", "AF"}, {"Kajrān", "AF"}, {"Paghmān", "AF"}, {"Ōkak", "AF"}, {"Vreshtas", "AL"}, {"The Valley", "AI"}, {"Lazarat", "AL"}, {"Martanesh", "AL"}, {"Bolands", "AG"}, {"Qal‘ah-ye Shahr", "AF"}, {"Dhivër", "AL"}, {"La‘l", "AF"}, {"Stoney Ground", "AI"}, {"Gardez", "AF"}, {"Ḩukūmatī Dahanah-ye Ghōrī", "AF"}, {"Përrenjas-Fshat", "AL"}, {"Qarah Bāgh Bāzār", "AF"}, {"Kuhsān", "AF"}, {"Picar", "AL"}, {"Dubai", "AE"}, {"Sarōbī", "AF"}, {"Khudāydād Khēl", "AF"}, {"The Quarter", "AI"}, {"Pāshmūl", "AF"}, {"Shupenzë", "AL"}, {"Pas de la Casa", "AD"}, {"Qaīşār", "AF"}, {"Mborje", "AL"}, {"Kōṯowāl", "AF"}, {"Kushk", "AF"}, {"Pachīr wa Āgām", "AF"}, {"Nūrgal", "AF"}, {"Liqenas", "AL"}, {"Përmet", "AL"}, {"Mandōl", "AF"}, {"Adh Dhayd", "AE"}, {"All Saints", "AG"}, {"Kalakān", "AF"}, {"Gjorica e Sipërme", "AL"}, {"Kā’ī", "AF"}, {"Khulbisāt", "AF"}, {"Qala i Naw", "AF"}, {"Rukaj", "AL"}, {"Zargarān", "AF"}, {"Mashhad", "AF"}, {"Zīārat-e Shāh Maqşūd", "AF"}, {"Nīkêh", "AF"}, {"Nāyak", "AF"}, {"Ghōriyān", "AF"}, {"Shīnḏanḏ", "AF"}, {"Tsapêraī", "AF"}, {"Dehdādī", "AF"}, {"Mīrābād", "AF"}, {"Darāyim", "AF"}, {"Māmā Khēl", "AF"}, {"Lāsh-e Juwayn", "AF"}, {"Amānzī", "AF"}, {"Herāt", "AF"}, {"Rustāq", "AF"}, {"Khayr Kōṯ", "AF"}, {"Dowlatābād", "AF"}, {"Pojan", "AL"}, {"Libohovë", "AL"}, {"Bābā Şāḩib", "AF"}, {"Falmouth", "AG"}, {"Sharan", "AF"}, {"Pul-e Khumrī", "AF"}, {"Māymay", "AF"}, {"Tunjë", "AL"}, {"Kakavijë", "AL"}, {"Tsamkanī", "AF"}, {"Encamp", "AD"}, {"Lekas", "AL"}, {"Mutā Khān", "AF"}, {"Āsmār", "AF"}, {"Gereshk", "AF"}, {"Parham", "AG"}, {"Ujmisht", "AL"}, {"Mazad", "AF"}, {"Āb-e Kamarī", "AF"}, {"Sāyagaz", "AF"}
    };


    @PostConstruct
    public void insertCities() {
        //if cities already have data don't insert
        if (cityRepository.findAll().isEmpty()) {
            for (String[] cityCountryPair : cityCountryDataArray) {
                String cityName = cityCountryPair[0];
                String countryIso = cityCountryPair[1];
                cityRepository.insertCity(cityName, countryIso);
            }
        }
    }
}
