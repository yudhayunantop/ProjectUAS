package com.dicoding.picodiploma.ProjectUAS.data

import com.dicoding.picodiploma.ProjectUAS.R

object FoodData {
    //data nama
    private val foodNames = arrayOf(
        "Es Teler Tanjung Anom",
        "Bikang",
        "Bubur Madura Pasar Atom",
        "Cakue Peneleh",
        "Kue Tok",
        "Lentho",
        "Lumpur Muda-Mudi",
        "Pastel Pucang",
        "Spikoe Resep Kuno",
        "Cincau Station")

    //data detail
    private val foodDetails = arrayOf(
        "Es teler yang satu ini wajib kamu cobain apabila kamu berkunjung ke Surabaya. Terutama jika kamu mampir di Jl. Taman Apsari No. 7 Genteng. Isian yang lengkap mulai dari alpukat, kelapa, muda, potongan nangka hingga paduan es serutnya yang menambah kenikmatan di cuaca Surabaya yang terik. Wah jadi ngiler banget nih!",
        "Kue Bikang atau carabikang merupakan kue tradisional yang terbuat dari tepung beras dengan bentuk bunga yang merekah beraneka warna. Kue Bikang menjadi jajanan pasar khas Surabaya yang biasa disantap di pagi atau sore hari.",
        "Bubur Madura yang terkenal berada di lantai dasar Pasar Atom Surabaya. Bubur Madura ini merupakan bubur yang tidak biasa seperti yang kita kenal. Jika bubur biasanya identik dengan rasa asin dan gurih, bubur Madura ini disajikan dengan rasa manis. Bubur Madura merupakan perpaduan bubur sumsum, bubur ketan hitam, dan bubur mutiara.",
        "Cakue merupakan salah satu jajanan yang banyak ditemui di Indonesia. Di Surabaya, ada salah satu cakue legendaris bernama cakue Peneleh. Yang membedakan Cakue Peneleh dengan cakue lain adalah adanya isiannya pada cakue ini.",
        "Kue Tok atau Kue Ku merupakan kue tradisional yang dipengaruhi oleh kuliner Tionghoa. Kue ini biasanya berwarna merah dengan bentuk oval menyerupai cangkang kura-kura. Kini banyak Kue Tok dengan berbagai bentuk seperti bentuk buah.",
        "Lentho terbuat dari kacang tolo atau kacang hijau. Di Surabaya, Lentho berukuran kecil sendiri selalu dijadikan sebagai salah satu racikan dari lontong balap. Bentuk lentho bulat memanjang menyerupai bentuk perkedel.",
        "Lumpur muda-mudi ini sangat digemari oleh khususnya warga Sidoarjo, memang sedikit jauh dari kota Surabaya tapi gak ada salahnya untuk mampir ke Jl. Dr. Wahidin No. 96B demi mencoba lumpur yang lumer di mulut. Kue lumpur ini terdapat beberapa varian yaitu original, durian, kelapa muda, keju, green tea, dan juga cokelat.",
        "Pastel Pucang ini berlokasi di Jl. Pucang Sawit No.28, Pucang Sewu, Gubeng dikelola oleh seorang ibu yang akrab dipanggil Oma Toety. Beliau sudah memulai usaha membuat pastel sudah cukup lama. Pastel yang disajikan ini juga terbatas dan pemesanannya hanya via telepon saja lho.",
        "Merek minuman satu ini mengangkat rasa otentik Indonesia. Dari namanya gerai Cincau Station menawarkan cincau minuman khas Indonesia. Cincau dikemas dalam gelas plastik dan disajikan dingin.Isian cincau yang ditawarkan sama dengan cincau yang dikenal di tengah masyarakat.",
        "Spikoe Resep Kuno ini sudah terkenal sejak puluhan tahun. Khas dari Spikoe Resep Kuno ini adalah tekstur spikuknya sangat lembut dan tentu saja tentang rasanya yang sangat autentik!"
        )

    //data harga
    private val foodPrice = intArrayOf(
        1000,
        2000,
        3000,
        4000,
        5000,
        6000,
        7000,
        8000,
        9000,
        10000
    )

    //data gambar
    private val foodImages = intArrayOf(
        R.drawable.bakso,
        R.drawable.bikang,
        R.drawable.bubur,
        R.drawable.cakue,
        R.drawable.kuetok,
        R.drawable.lentho,
        R.drawable.lumpur,
        R.drawable.pastel,
        R.drawable.spiku,
        R.drawable.cincau
    )

    //add ke Array List
    val listData: ArrayList<food>
        get() {
            val list = arrayListOf<food>()
            for (position in foodNames.indices) {
                val food = food()
                food.name = foodNames[position]
                food.detail = foodDetails[position]
                food.price = foodPrice[position]
                food.photo = foodImages[position]
                list.add(food)
            }
            return list
        }
}


