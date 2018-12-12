package model

data class Gift(
        val id: Int,
        val category: String,
        val name: String,
        val value: Int,
        val url: String,
        var redeemCode: String
)