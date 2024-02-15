package com.clerodri.todopayments.featureAuth.data.datasource.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class UserDatabaseTest : TestCase() {


    private lateinit var db: UserDatabase
    private lateinit var dao: UserDao

    @Before
    public override fun setUp() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
        dao = db.userDao()
        super.setUp()

    }

    @After
    fun closeDb() {

        db.close()

    }

    @Test
    fun addUsertoDb() = runBlocking {

        val user = User("Ronaldo", "Rodriguez", "clerodri")
        dao.insertUser(user)
        val list = dao.getAllUsers()
        assertEquals(1, list.size)
    }

    @Test
    fun deleteUsertoDb()= runBlocking{
        val user = User("Ronaldo", "Rodriguez", "clerodri")
        val user2 = User("Rodrigo", "Rodriguez", "clerodri")
        dao.insertUser(user)
        dao.insertUser(user2)
        val user1Inserted = dao.getUserById(1)
        user1Inserted.let {
            dao.deleteUser(it)
        }
        val listUsers = dao.getAllUsers()
        assertEquals(1, listUsers.size)
        assertEquals("Rodrigo",listUsers[0].firstName)
    }
    @Test
    fun getAllUsersfromDb()= runBlocking {
        var listUsers = dao.getAllUsers()

        if (listUsers.isEmpty()){
            val user = User("Ronaldo","Rodriguez","rr")
            dao.insertUser(user)
        }
        listUsers= dao.getAllUsers()
        assertEquals(1,listUsers.size)
    }


}