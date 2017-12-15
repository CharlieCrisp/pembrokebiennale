package uk.co.pembrokemayball.pembrokebiennale;

import java.security.PublicKey;

/**
 * Created by charl on 14/06/2017.
 */

public class WhatsOnInfoContainer {

    public static WhatsOnItem[] ents = {
            new WhatsOnItem("MAGICIAN", "Roaming", "9 PM - 1 AM ", "What could make this evening more magical than our very own magician? Be amazed by the spectacular Danilo! Queue entertainment, and then roaming until 1am.", 9,13),
            new WhatsOnItem("CARIACATURIST", "Foundress", "9 PM - 2 AM ", "Capture the fun with a caricature.",9,14),
            new WhatsOnItem("MAGIC SELFIE MIRROR", "Old Court", "9 PM - 3 AM ", "Capture the fun of the evening the only way we know how - with a selfie! Unlimited prints and props throughout the evening.",9,15),
            new WhatsOnItem("CASINO", "Old Library", "9 PM - 3 AM ", "Make like Bond and test your skills at any of our five casino tables.",9,15),
            new WhatsOnItem("COMEDY ACTS", "Ivy Court", "All Night ", "Keep your eyes open for the small stage where our comedians will be hoping to tickle your funny bones throughout the night!",9,20),
            new WhatsOnItem("DODGEMS ", "New Court", "All Night", "Release some of that pent up frustration at our Pembroke staple.",9,20),
            new WhatsOnItem("KARAOKE", "Junior Parlour", "All Night", "Sing your heart out to your favourite tunes.",9,20),
            new WhatsOnItem("ARCADE ", "Fellow’s Carpark", "All Night", "Challenge yourself against the retro epics of old in the arcade. ",9,20),
            new WhatsOnItem("FERRIS WHEEL ", "Red Buildings", "All Night", "Pair-up and release some energy on this high speed ride.",9,20),
            new WhatsOnItem("KAE KURD ", "Hall", "10 PM - 10.30 PM ", "Risky and raucous political laughter courtesy of rising British-Kurdish star, Kae Kurd.",10,11),
            new WhatsOnItem("DANE BAPTISTE, COMEDY HEADLINER ", "Hall", "10.30 - 11 PM ", "Comedy headliner and 2014 Foster’s Edinburgh Comedy Awards Best Newcomer nominee. ",10,11),
            new WhatsOnItem("PORTRAIT PHOTOGRAPHY ", "Inner Parlour", "10 PM - 1 AM ", "Remember the night forever with portrait photography courtesy of Lafayette. Prints available to buy after the ball.",10,13),
            new WhatsOnItem("SWING BOATS", "Red Buildings", "All Night", "Pair-up and release some energy on this high speed ride.",9,20),
            new WhatsOnItem("HENNA", "Fellows’ Garden", "10 PM - 2 AM ", "Transform yourself into one of the masterpieces yourself with Henna tattoos.",10,14),
            new WhatsOnItem("CINEMA ", "Master’s Garden", "10 PM - 2 AM ", "Relax and unwind in front of some arthouse classics.",10,14),
            new WhatsOnItem("GLITTER FACE PAINT ", "Junior Parlour", "10 PM - 2 AM ", "Add a little sparkle to you get-up with glitter face painting and tattoos.",10,14),
            new WhatsOnItem("SHISHA ", "Fellows’ Garden", "10 PM - 5 AM ", "Take some time out ",10,17),
            new WhatsOnItem("LIFE DRAWING ", "Thomas Gray Room", "Midnight - 2 AM ", "Escape the madness of the ball and let your inner DaVinci loose on the page.",12,14),
            new WhatsOnItem("HAIR AND MAKEUP TOUCH UP ", "Graduate Parlour", "1 AM - 3 AM ", "Courtesy of Finn Jordan.",13,15),
            new WhatsOnItem("CEILIDH ", "Hall", "1 AM - 3 AM ", "Let off some steam, and bust some moves at our very own Ceilidh.",13,15)};

    public static WhatsOnItem[] drinks = {
            new WhatsOnItem("CHAMPAGNE RECEPTION ","Old Court","9 PM - 10.30 PM ","Take in the beauty of Old Court with a delightful glass of champagne in hand.",9,11),
            new WhatsOnItem("COCKTAIL BOX ","New Court","9 PM - 2 AM ","Enjoy watching the mixologists concoct an array of exciting cocktails, beautifully presented.",9,14),
            new WhatsOnItem("MIDAS GOLD MEAD COCKTAILS ","Old Library","9 PM - 2.30 AM ","The reinvention of an ancient drink, this orange blossom mead spritzer really shines.",9,15),
            new WhatsOnItem("TEQUILA SHOTS ","Library Lawn","9 PM - 2.30 AM ","An old favourite, this tequila packs a punch in taste. ",9,15),
            new WhatsOnItem("FIZZ BAR ","Ivy Court","9 PM - 4.30 AM ","The bubbly will flow late into the night in the varieties of classic, pink and elderflower.",9,17),
            new WhatsOnItem("SAN PELLEGRINO SUNSET ","Hall","All Night","Enjoy the whole range of zesty sparkling citrus drinks.",9,20),
            new WhatsOnItem("HOT DRINKS ","Graduate Parlour","All Night","Warming coffee and teas can be found here all night.",9,20),
            new WhatsOnItem("MAIN BAR","Bowling Green","All Night","Whatever your tipple we have got you covered at the main bar with beer, cider, wine, plenty of soft drinks and water available.",9,20),
            new WhatsOnItem("VODKA SHOT RAINBOW ","Fellows’ Carpark","All Night","Discover a whole spectrum of new vodka flavours.",9,20),
            new WhatsOnItem("SANGRIA ","Foundress","All Night","Rich, fruity and refreshing. Perfect on a summer evening. ",9,20),
            new WhatsOnItem("GIN BAR ","Fellows’ Garden","All Night","Come for the classic G&Ts, stay for the exquisite, minty gin mojitos.",9,20),
            new WhatsOnItem("BEER & CIDER ","Hall","All Night","A selection of beers and ciders will be on offer to sip whilst relaxing and watching some comedy, or to quench a thirst after a lively ceilidh.",9,20),
            new WhatsOnItem("HYDRATION POINT ","Library Lawn","All Night","Stay fresh by picking up an iced tea, ginger beer, or bottle of water between courts. ",9,20),
            new WhatsOnItem("SMOOTHIES ","Library Lawn","All Night","Get your five-a-day with our selection of different smoothies, each bursting with flavour.",9,20),
            new WhatsOnItem("MILTON BREWERY TENT ","Red Buildings","all Night","Sample some of this local brewery’s delicious, award-winning ales and beers.",9,20),
            new WhatsOnItem("PORT & WINE TASTING ","Outer Parlour","10.30 PM - 5 AM ","Come to taste a sumptuous selection of ports and wines that have been expertly paired with the divine cheeses on offer.",10,17),
            new WhatsOnItem("JÄGERBOMBS ","New Court","11 PM - 3.30 AM ","Need an energy hit? Look no further than the jägermeister and relentless bar.",11,16),
            new WhatsOnItem("THE GREAT AMERICAN SHAKE ","Red Buildings","11.30 PM - 4 AM ","You won’t be able to resist our thick vanilla coffee milkshakes with a boozy kick. ",11,16),
            new WhatsOnItem("VKs","Orchard","1 AM - 5 AM ","Grab a VK at the silent disco, you won’t need to stop dancing, even for a minute.",13,17),
            new WhatsOnItem("CAFFÈ MOBILE  ","Old Court","2 AM - 5.45 AM ","What we all need in the early hours of the morning is good, hot coffee, and Caffè Mobile is the best of the best.",14,18),
            new WhatsOnItem("BREAKFAST JUICES ","Library Lawn","4.30 AM - END","Watch the sun come up with a revitalising fruit juice. The perfect accompaniment to a spot of breakfast.",16,20)
    };

    public static WhatsOnItem[] food = {
            new WhatsOnItem("BARBEQUE (V)","New Court","9 PM – 1.30 AM ","Fuel up in preparation for the night ahead with these 100% steak 1/4lb cheese or vegetable burgers.",9,14),
            new WhatsOnItem("THAI GREEN CURRY (V)","New Court","9 PM – 2 AM","Fuel up for the evening ahead with a spicy kick of Thai Green chicken or Red vegetable curry.",9,14),
            new WhatsOnItem("THE WANDERING YAK (V, GF, VG)","Foundress Lawn","9 PM – 2 AM ","Set your tastebuds on fire with scrumptious mezze boxes of baked feta, hummus, butternut squash, and griddled handmade pitta.",9,14),
            new WhatsOnItem("MAC ‘N’ CHEESE (V)","Red Buildings Lawn","9 PM – 2.30 AM ","The ultimate to satisfy any appetite: choose from three mouth-watering, inventive flavours. ",9,15),
            new WhatsOnItem("HOT SAUSAGE COMPANY ","Foundress Lawn","9 PM – 3 AM ","A traditional and special sausage range served from their Victorian Barrow.",9,15),
            new WhatsOnItem("AROMI PIZZA (V, VG)","Foundress Lawn","9 PM onwards ","Indulge your cravings with a selection of the finest Sicilian pizza with a variety of tasty toppings.",9,20),
            new WhatsOnItem("PICK ‘N’ MIX (VG, GF)","Master’s Garden","All Night","Indulge your childish fantasies at our whimsical cart.",9,20),
            new WhatsOnItem("PIE CLUB (V)","Foundress Lawn","10 PM – 2 AM ","Tuck into proper English pies with a selection of delicious fillings, served with creamy mash and gravy.",10,14),
            new WhatsOnItem("JUICY SWINE (GF)","Ivy Court","10 PM – 2 AM ","Tuck into Juicy Swine’s signature spicy chorizo or halloumi, served in freshly baked baguettes.",10,14),
            new WhatsOnItem("JACK’S GELATO (V, GF, VG)","Ivy Court","10 PM – 3 AM ","Visit Jack’s ice cream cart for a choice of six fabulous and colourful flavours of freshly-made ice cream and sorbet.",10,15),
            new WhatsOnItem("AROMI DESSERTS (V, GF)","Library Lawn","10 PM onwards","Indulge yourself with delicate Sicilian treats, including melt-in-the-mouth chocolate and pistachio tarts.",10,20),
            new WhatsOnItem("MR BAKEY CUPCAKES (V, VG, GF)","Library Lawn","10 PM onwards ","Scrumptious and colourful cupcakes topped with moreish buttercream frosting.",10,20),
            new WhatsOnItem("BELGIUM WAFFLES (V)","Library Lawn","11 PM onwards ","Warm, classic, sugary waffles served with rich chocolate sauce and marshmallows. From 2am we will have maple syrup and bacon.",11,20),
            new WhatsOnItem("PORT AND WINE TASTING (V, GF)","The Ivy Parlours","11 PM onwards","Come to taste a sumptuous selection of ports and wines paired with divine cheeses. ",11,20),
            new WhatsOnItem("YUBBA YUBBA DOUGHNUTS (V)","Foundress Lawn","Midnight – 5 AM ","Freshly cooked gourmet doughnuts coated in sugar and smothered in rich, hot chocolate sauce.",12,17),
            new WhatsOnItem("CROISSANTS & PASTERIES (V)","Library Lawn","2.30 AM onwards ","Greet the coming morning with a freshly baked continental breakfast fit for a king.",14,20),
            new WhatsOnItem("SWEET POTATO FRIES (V, VG, GF)","Red Buildings Lawn","2.30 onwards ","A tasty and sophisticated twist on classic French fries.",14,20),
            new WhatsOnItem("THE MORNING AFTER BACON ROLLS ","Old Court","2 AM onwards ","The Morning After Bacon Rolls - satisfy your morning hunger with crispy bacon served in floury white rolls.",14,20)
    };

    public static WhatsOnItem[] music = {
            new WhatsOnItem("KIERAN DALY","Ivy Court","9.15 PM - 9.45 PM ","Valencian singer-songwriter Kieran Daly and his band are opening the Ivy Court stage with an impressive array of original indie-folk tunes to greet guests as they arrive at the ball.",9,10),
            new WhatsOnItem("CHURCHILL JAZZ ","Main Stage on Bowling Green","9.20 PM - 10.20 PM ","Churchill Jazz will be opening the main stage in style with their repertoire of jazz hits from swing to funk and everything in between. ",9,11),
            new WhatsOnItem("SAACHI SEN ","Ivy Court","9.50 PM - 10.35 PM ","Armed with an acoustic guitar and an incredible voice, Saachi sen can turn heads like no one else. Expect to be captivated by her voice as you enjoy the beautiful impressionistic surroundings.",9,11),
            new WhatsOnItem("HOLLY MUSGRAVE ","Ivy Court","10.40 PM - 11.10 PM ","Pianist and singer Holly Musgrave has been featured on BBC Introducing and her voice is never short of praise, look forward to being wowed by her powerful singing.",10,12),
            new WhatsOnItem("KYLA LA GRANGE ","Main Stage on Bowling Green","10.40 PM - 11.40 PM","Renowned singer-songwriter and Pembroke alumna Kyla La Grange will be bringing her diverse collection of indie pop hits to the Bowling Green, where they'll be sure to entertain her fellow Valencians.",10,12),
            new WhatsOnItem("CHICKEN SUPREMES","Hall","11 PM - 11.45 PM ","Prepare to be turned upside down and inside out by the Chicken Supremes, who will be bringing the incredible discography of Diana Ross and the Supremes to the Hall stage, with material ranging from motown to 80's funk.",11,12),
            new WhatsOnItem("LOYLE CARNER ","Main Stage on Bowling Green","Midnight - 00.40 AM","Critically-acclaimed London rapper Loyle Carner will be taking over at midnight, get ready for an intimate set of soulful tunes with his signature heartfelt vocals.",12,13),
            new WhatsOnItem("BETTER THAN THE LAST GUY ","Hall","Midnight - 00.45 AM","Cambridge duo Better Than The Last Guy will be playing their collection of acoustic folk tunes for anyone looking for a laid back alternative to the headline acts.",12,13),
            new WhatsOnItem("LUSTS ","Main Stage on Bowling Green","1 AM - 1.40 AM","Leicester-based group Lusts' effects-driven and unique take on rock has drawn praise from NME, the Guardian and many other music publications. For fans of post-punk and indie rock this is not one to be missed.",13,14),
            new WhatsOnItem("SILENT DISCO","Orchard","1AM - 5 AM ","Jonnie Penn & Harley Katz (1 AM - 3 AM) \n" +
                    "Pembroke's own Jonnie Penn & Harley Katz will be kicking off the silent disco at 1am. Some may know Jonnie as a Canadian television personality and author of New York Times bestseller “What Do You Want To Do Before You Die?”, being a professional DJ is another one of his hobbies. Harley has been a mainstay of Pembroke bops for many years now so expect plenty of bangers.\n",13,15),
            new WhatsOnItem("COLONEL SPANKY’S LOVE ENSEMBLE ","Main Stage on Bowling Green","2 AM - 3 AM ","May Ball regulars Colonel Spanky's Love Ensemble are back again this year by popular demand. Expect to be left exhausted after an hour of being unable to keep still as they bring their funky grooves to the Bowling Green once more.",14,13),
            new WhatsOnItem("STAYCATIONS","Hall","3.15 AM - 4 AM ","Alternative rock fans won't be disappointed by Staycations, a modern rock outfit from Cambridge that have been featured on Radio 1 and performed at many music festivals over the past few years. ",15,16),
            new WhatsOnItem("SASHA FIERCE ","Main Stage on Bowling Green","3.20 AM - 4.20 AM","Beyonce fans will be excited to hear that although the Queen herself won't be making an appearance, tribute act Sasha Fierce will be channeling her diva demeanour as the dawn approaches.",15,17),
            new WhatsOnItem("SILENT DISCO","Orchard","1AM - 5 AM ","MASTIFF (3 AM - 5 AM) \n" +
                    "Brighton-based DJ MASTIFF is taking over at 3, and will be delivering music from genres across the board for everyone to enjoy. He has performed at many balls.\n",15,17),
            new WhatsOnItem("MOON FLOWER","Hall",", 4.15 AM - 5 AM ","Jazz-funk ensemble Moonflower will be causing feet to move and hips to shake with their catalogue of funky sounds.",16,27),
            new WhatsOnItem("NICK CARTER ","Main Stage on Bowling Green","4.40 AM - 5.45 AM ","BBC Radio DJ Nick Carter will once again will be rounding off the Ball with a stellar set of tunes that everyone can get behind. ",16,18),
            new WhatsOnItem("ADELAIDE ","Hall",", 5.15 AM - 5.45 AM ","Round off the night with a selection of high octane rock and indie covers from these Pembroke veterans. ",17,18)
    };

}
