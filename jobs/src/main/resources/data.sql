INSERT INTO ROLES (ROLE_NAME) VALUES ('ADMIN');
INSERT INTO ROLES (ROLE_NAME) VALUES ('USER');
INSERT INTO ROLES (ROLE_NAME) VALUES ('WORKER');

INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Autoszerelo', '1.png');
INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Villanyszerelo', '2.png');
INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Viz-gaz-futesszerelo', '3.png');
INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Kertesz', '4.png');
INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Asztalos', '5.png');
INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Festo', '6.png');
INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Haztartasi gepszerelo', '7.png');
INSERT INTO CATEGORIES (CATEGORY_NAME, PICTURE) VALUES ('Komuves', '8.png');



INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest I.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest II.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest III.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest IV.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest V.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest VI.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest VII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest VIII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest IX.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest X.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XI.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XIII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XIV.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XV.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XVI.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XVII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XVIII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XIX.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XX.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XXI.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XXII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Budapest XXIII.');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Godollo');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Gyor');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Szekesfehervar');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Miskolc');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Debrecen');
INSERT INTO LOCATIONS (LOCATION_NAME) VALUES ('Szekszard');

INSERT INTO USERS (USER_TYPE, PASSWORD, USERNAME, ROLE_ID, NAME) VALUES ('Admin', 'admin','admin',1, 'Tomi');
INSERT INTO USERS (USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, LOCATION_ID) VALUES ('User', 'user','user',2, 'asd1@asd.hu',  'Jancsi', '06202121', 11);
INSERT INTO USERS (USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, LOCATION_ID) VALUES ('User', 'user','kutyabarat21',2, 'asdzdt@asd.hu',  'Eniko', '06202122',1);
INSERT INTO USERS (USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, LOCATION_ID) VALUES ('User', 'user','jozsef882',2, 'asd323@asd.hu',  'Jozsef', '06202123',4);
INSERT INTO USERS (USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, LOCATION_ID) VALUES ('User', 'user','szilviuser',2, 'kutyak@asd.hu',  'Szilvi', '06202124',6);
INSERT INTO USERS (USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, LOCATION_ID) VALUES ('User', 'user','kshai',2, 'ksk@asd.hu', 'Dani', '06202125',8);


INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('kriszti1992.jpg', 'Worker', 'krisz','kriszti1992',3, 'kriszti92@gmail.com', 'Kriszti', '062022126',1, 'Foglalkozom regi illetve ujabb evjaratu autok szervizelesevel, szeretettel varom a muhelyemben, illetve kiszallasra is van lehetoseg!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('ferenc.jpg', 'Worker', 'kriz','ferenc',3, 'ferenc1995@gmail.com', 'Ferenc Ajtos', '06302218787',1, 'Udv! Fiatalos, de tapasztalt csapat varja Ont szervizunkben Budapesten, a fo profilunk a japan illetve a koreai gyartmanyu autok javitasa.');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('javito.jpg', 'Worker', 'kisz','javito',3, 'javitok@gmail.com', 'Javito Jani', '06202233236',1, 'Kozel 20 eve foglalkozom BMW, Mercedes, Audi, Opel es egyeb nemet gyartmanyu autok szervizelesevel, forduljon bizalommal hozzank!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('kerekes.jpg', 'Worker', 'kisz','kerekes',3, 'kerek@gmail.com', 'Kerekes Geza', '06202233236',1, 'Gumis illetve kerekjavito szervizembe varom a vendegeket, barmilyen tipusu autora/tehergepjarmuvel foglalkozunk!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('tamas.jpg', 'Worker', 'kisz','tamas',3, 'tamas13@gmail.com', 'Jarvas Tamas', '06709498873',1, 'Nagy kapacitassal rendelkezo szervizemben varom Budapest sziveben!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('autos.jpg', 'Worker', 'kisz','autos',3, 'autospeti@gmail.com', 'Autos Peter', '062022556236',1, 'Motorok, illetve kisteherautok szervizelese is megoldhato nalunk, kuldjon uzenetet!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('erika778.jpg', 'Worker', 'pass','erika778',3, 'erika778@asd.hu', 'Nagy Erika', '06202126',1, 'Foglaljon idopontot es autojat akar par oran belul megvizsgaljuk, a felmeres utan az arlistat figyelembe veve kap tolunk ajanlatot!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('barat.jpg', 'Worker', 'kisz','barat',3, 'barattamas@gmail.com', 'Barat Tamas', '062022556236',1, 'Alvazjavitasra nem talal jobb embert nalam, vegye fel a kapcsolatot!');

INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('alma112.jpg','Worker', 'almafa','alma112',3, 'almaalma@citromail.hu', 'Kovacs Alma', '06708765657',2, 'Udvozlom! Kedvezmenyes kiszallasi dijjal allok rendelkezesere, az arlistamon mindent megtalal, tovabbi informaciokert kuldjon uzenetet!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('peter.jpg','Worker', 'almafa','peter',3, 'peternagy@citromail.hu', 'Nagy Peter', '06708765657',2, '20 eve villanyszerelessel foglalkozom, a felmeres utan kepessegeimhez merten barmit meg tudok valositani!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('laci.jpg','Worker', 'almafa','laci',3, 'laci1993@citromail.hu', 'Laszlo', '06708765657',2, 'Barmilyen villanyszerelesi, illetve epuletgepeszeti munkaval keressen bizalommal, velem a leggyorsabban megvalosithatja terveit! ');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('andris5.jpg','Worker', 'almafa','andris5',3, 'andris1956@citromail.hu', 'Alma Andras', '067065657',2, 'Uj kapcsolok, dugaljak, lampak felszerelese? Az ilyen gyors munkakat kedvezmenyes aron vegzem el, tudva milyen gyorsan szukseg lehet az ilyen aprosagokra! ');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('feri22.jpg','Worker', 'almafa','feri22',3, 'ferenc@freemail.hu', 'Szegedi Ferenc', '06708766757',2, 'Nagyobb intezmenyek, ingatlanok teljeskoru villanyszerelesevel is foglalkozom, ilyen munka eseten uzenetben keressen fel mindenkepp! ');

INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('aladar.jpg','Worker', 'alad','aladar',3, 'aladar47@freemail.hu', 'Arany Aladar', '06708766757',3, 'Viz-gaz es futessel is foglalkozom, az arlistan ilyen jellegu feladatokat is megtalal. Leggyakrabban csaladi hazak, illetve uj epitesu ingatlanok szerelesehez/epitkezesehez hivnak, hivjon On is!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('istvan.jpg','Worker', 'alad','istvan',3, 'kovacs.istvan@freemail.hu', 'Kovacs Istvan', '06708766757',3, '30 eves tapasztalattal rendelkezem, egeszen az egyszeru dugulastol a teljes vizesblokk beszereleseig. Ne feledje, ha vizszereles, akkor Kovacs Istvan!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('bence.jpg','Worker', 'alad','bence',3, 'bence.kiss@freemail.hu', 'Kiss Bence', '06708766757',3, 'Fiatalos, gyors munkavegzes, kis felar eseten villamfelmeressel, irjon ram :) !');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('denes.jpg','Worker', 'alad','denes',3, 'denes77@citromail.hu', 'Horvath Denes', '06207896765',3, 'Futesrendszer a fo szakteruletem, ezek kozul gazos, elektromos, de akar fatuzeleses megoldasokat is konyneden szerelek/epitek!');


INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('lilla12.jpg','Worker', 'kutya2','lilla12',3, 'lilla12@hotmail.hu', 'Fekete Lilla', '0620212229',4, '');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('kerteszferi.jpg','Worker', 'kutya4','kerteszferi',3, 'kerteszferenc@hotmail.hu', 'Kertesz Ferenc', '06304567676',4, 'Faiskolaban dolgoztam 10 evig, gyumolcsoskertek gondozasaval, erdeszeti munkakkal foglalkoznek, kisebb munkakent akar favagassal is!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('sandor.jpg','Worker', 'kutya2','sandor',3, 'sandor@hotmail.hu', 'Foldes Sandor', '0620212229',4, 'Viragoskertek illetve akar zoldsegeskertek karbantartasaval kapcsolatban keressen nyugodtan!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('antal.jpg','Worker', 'kuter','antal',3, 'antalj40@hotmail.hu', 'Jonas Antal', '06704453434',4, '30 eves tapasztalattal rendelkezo kertesz keres csaladi hazat vagy birtokot, amit felugyelhet.');

INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('girl126.jpg','Worker', 'kutya','girl126',3, 'erzsike@asd.hu', 'Erzsebet', '0620222128',5, 'Egyedi butorok es haztartasi eszkozok keszitesevel tervezesevel foglalkozunk, ha van barmilyen otlete vegye fel a kapcsolatot es megnezzuk mit tehetunk!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('gabor.jpg','Worker', 'kutya','gabor',3, 'gabor@gmail.hu', 'Takacs Gabor', '067210101',5, 'Kisebb butorok keszitesevel foglalkozom, csak a legjobb minosegu alapanyagokbol!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('karoly.jpg','Worker', 'kutya','karoly',3, 'karoly@freemail.hu', 'Tolgyes Karoly', '0688799867',5, 'Udvozlom! Barmilyen faipari termek elolallitasat rank bizhatja a gerendatol egeszen a hajopadloig!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('lajos.jpg','Worker', 'kutya','lajos',3, 'lajos@gmail.hu', 'Feher Lajos', '0620222128',5, 'Fa asztalok, szekek egyedi megrendelesre, limitalt peldanyszamban, kuldjon uzenetet arajanlatra!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('marcell.jpg','Worker', 'kutya','marcell',3, 'marcell@gmail.hu', 'Marcell', '0620232221',5, '30 eves tapasztalattal rendelkezo asztalosmester varja a hivasat.');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('lali.jpg','Worker', 'kutya','lali',3, 'laliapu@gmail.hu', 'Gerendas Lajos', '0620232221',5, 'Muhelyemben barmilyen szekreny, garbrobszekreny, konyhabutor, nappali butor vagy komod kesziteset vallalom!');


INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('szilvi.jpg','Worker', 'cica','szilvi',3, 'szilvi79@freemail.hu', 'Barat Szilvia', '06202120',6, 'Szobafestes most kedvezmenyes aron, a hely meretetol fuggoen, akar mennyisegi kedvezmennyel is, keressen batran!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('festo.jpg','Worker', 'cica','festo',3, 'oli55@freemail.hu', 'Kocka Oliver', '06202189920',6, 'Az anyag miatt se aggodjon, a festek kevereset en magam vegzem minosegi alapanyagokbol, evtizedes szakertelemmel!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('joe.jpg','Worker', 'cica','joe',3, 'joe21@freemail.hu', 'Barna Jonas', '06202189920',6, 'Muveszi kepek festesevel is foglalkoztam par evig, igy akar gyermekszobai rajzokat is festhetek egyedi otlet alapjan.');

INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('david.jpg','Worker', 'cica','david',3, 'david33@freemail.hu', 'Budai David', '06202189920',7, 'Kedvezo kiszallasi dijjal vallalom mosogepek, hutogepek, mosogatogepek szervizeleset, keressen uzenetben ajanlatert!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('jani.jpg','Worker', 'cica','jani',3, 'jancsika@freemail.hu', 'Pesti Janos', '06202189920',7, 'Pesti Janos, a mosogepek szakertoje: barmilyen markaju es tipusu mosogep javitasaval foglalkozom, legyen akar kisebb meghibasodasrol szo vagy akar nagyobb komponensek cserejerol!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('feco.jpg','Worker', 'cica','feco',3, 'fecofeco@freemail.hu', 'Ferenc Oliver', '06202189920',7, 'Akar televiziorol, akar mosogeprol van szo, hivjon batran es megnezem mi a gond!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('geri.jpg','Worker', 'cica','geri',3, 'geri22@freemail.hu', 'Balatoni Gabi', '06202189920',7, 'Nem megy a tv? Nincsen internet? Irjon ram es par oran belul mar ott is vagyok, ingatlanok kabelezesevel is foglalkozom es egyeb aprosagokkal!');

INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('gergo.jpg','Worker', 'cica','gergo',3, 'gergely@freemail.hu', 'Erdei Gergo', '06202189920',8, 'Hazak epiteseben szerzett 20 eves tapasztalattal varom a leendo ugyfeleim, ha betonozasra, falepitesre vagy alapozasra van szuksege!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('mate.jpg','Worker', 'cica','mate',3, 'mate126@freemail.hu', 'Matek Mate', '06202189920',8, 'Csapatommal vallaljuk hazak epiteset, alapozasat, igeny eseten tervezeset is, forduljon hozzank bizalommal!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('komuves.jpg','Worker', 'cica','komuves',3, 'gyuripapa@freemail.hu', 'Komuves Gyuri', '06202189920',8, 'Barmilyen egyedi otlet megvalostiasat vallalom elozetes egyeztetes utan, gyors munkaidovel!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('gazsi.jpg','Worker', 'cica','gazsi',3, 'gerzson@freemail.hu', 'Gerzson', '06202189920',8, 'Udv! Az alapveto komuves munkakon kivul hoszigetelest, burkolast, kulso festest is vallalunk, ha minket valaszt az ingatlanja idotallo lesz evtizedek mulva is!');
INSERT INTO USERS (IMAGE, USER_TYPE, PASSWORD, USERNAME, ROLE_ID, EMAIL, NAME, PHONE_NUM, CATEGORY_ID, DESCRIPTION) VALUES ('peti95.jpg','Worker', 'cica','peti95',3, 'peter.95@freemail.hu', 'Kalap Peter', '06306754432',8, 'Falazas, vakolas, nyilaszarok behelyezese, ezek csak izelitok a szeles palettankrol, kuldjon uzenetet vagy hivjon minket meg ma!');

INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('olajcsere', '1000-2000 Ft', 7);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('olajcsere', '1000-2000 Ft', 7);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('olajcsere', '1000-2000 Ft', 7);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('olajcsere', '1000-2000 Ft', 7);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('kerekcsere', '50000 Ft', 8);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('kerekcsere', '50000 Ft', 8);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('kerekcsere', '50000 Ft', 8);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('kerekcsere', '50000 Ft', 8);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('kerekcsere', '50000 Ft', 8);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('asztal', '50000 Ft', 9);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('fa', '50000 Ft', 9);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('raty', '50000 Ft', 9);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('szek', '50000 Ft', 10);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('szek', '50000 Ft', 10);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('szek', '50000 Ft', 10);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('szek', '50000 Ft', 10);
INSERT INTO TASKS (TASK_NAME, TASK_PRICES, WORKER_ID) VALUES ('szek', '50000 Ft', 10);


INSERT INTO MESSAGES (CONTENT, IS_SEEN, SEND_TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('jonapot kivanok user, laci vagyok', 'false', current_timestamp, 2,3);
INSERT INTO MESSAGES (CONTENT, IS_SEEN, SEND_TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('jonapot kivanok laci, user vagyok', 'false', current_timestamp, 7,4);
INSERT INTO MESSAGES (CONTENT, IS_SEEN, SEND_TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('jonapot kivanok laci, user vagyok', 'false', current_timestamp, 5,2);
INSERT INTO MESSAGES (CONTENT, IS_SEEN, SEND_TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('jonapot kivanok laci, user vagyok', 'false', current_timestamp, 3,4);
INSERT INTO MESSAGES (CONTENT, IS_SEEN, SEND_TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('jonapot kivanok laci, user vagyok', 'false', current_timestamp, 7,1);

INSERT INTO USERS_FAVORITES (USER_ID, WORKER_ID) VALUES (2,8);
INSERT INTO USERS_FAVORITES (USER_ID, WORKER_ID) VALUES (2,9);
INSERT INTO USERS_FAVORITES (USER_ID, WORKER_ID) VALUES (2,10);
INSERT INTO USERS_FAVORITES (USER_ID, WORKER_ID) VALUES (2,11);
INSERT INTO USERS_FAVORITES (USER_ID, WORKER_ID) VALUES (3,7);
INSERT INTO USERS_FAVORITES (USER_ID, WORKER_ID) VALUES (3,8);

INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('Jo volt a fiu', '2', current_timestamp, 7,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok remek munka', '5', current_timestamp, 8,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('A munka végzését elvégezte A munka végzését elvégezte A munka végzését elvégezte A munka végzését elvégezte A munka végzését elvégezte A munka végzését elvégezte A munka végzését elvégezte A munka végzését elvégezte ', '5', current_timestamp, 9,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, pdsadasetinnak', '4', current_timestamp, 7,3);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petinnak', '4', current_timestamp, 7,4);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('dasdasd, petidasdasdsannak', '2', current_timestamp, 7,5);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petinnak', '1', current_timestamp, 7,6);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petinnak', '5', current_timestamp, 10,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, dsdssdsda', '2', current_timestamp, 11,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petsadasdasdinnak', '3', current_timestamp, 12,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('asddas vok, pedsadsatinnak', '4', current_timestamp, 13,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('asddas vok, pedsadsatinnak', '4', current_timestamp, 13,3);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petinnak', '5', current_timestamp, 14,2);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user das, petinnak', '3', current_timestamp, 8,3);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petinnak', '4', current_timestamp, 8,4);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petidasnnak', '1', current_timestamp, 8,5);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petidasnnak', '1', current_timestamp, 15,5);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petidasnnak', '5', current_timestamp, 15,4);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petidasnnak', '2', current_timestamp, 15,3);
INSERT INTO RATINGS (CONTENT, RATING, TIMESTAMP, RECIPIENT_ID, SENDER_ID) VALUES ('user vok, petidasnnak', '1', current_timestamp, 15,2);

INSERT INTO WORKERS_LOCATIONS (WORKER_ID, LOCATIONS_ID) VALUES (7,1);
INSERT INTO WORKERS_LOCATIONS (WORKER_ID, LOCATIONS_ID) VALUES (7,2);
INSERT INTO WORKERS_LOCATIONS (WORKER_ID, LOCATIONS_ID) VALUES (8,2);