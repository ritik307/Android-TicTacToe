package com.first.ritik.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var winner:Int=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buclick(view:View)
    {
        val buttonSelected= view as Button
        
        var buID=0
        when(buttonSelected.id)
        {
            R.id.b01->buID=1
            R.id.b02->buID=2
            R.id.b03->buID=3
            R.id.b04->buID=4
            R.id.b05->buID=5
            R.id.b06->buID=6
            R.id.b07->buID=7
            R.id.b08->buID=8
            R.id.b09->buID=9
        }
        //Toast.makeText(this,"ID is "+buID, Toast.LENGTH_SHORT).show()
        if(winner==-1)
            PlayGame(buID,buttonSelected)
        checkWinner()
        //autoPlay()
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var ActivePlayer=1
    fun PlayGame(callID:Int,buSelected:Button)
    {
        if(ActivePlayer==1)
        {
            buSelected.text="X"
            buSelected.textSize=20F
           // buSelected.t
            buSelected.setBackgroundResource(R.color.PaleTurquoise)
            player1.add(callID)
            ActivePlayer=2
            autoPlay()
        }
        else
        {
            buSelected.text="O"
            buSelected.textSize= 20F
            buSelected.setBackgroundResource(R.color.MistyRose)
            player2.add(callID)
            ActivePlayer=1
        }
        buSelected.isEnabled=false
    }

    fun checkWinner()
    {

        //row
        if(player1.contains(1) && player1.contains(2) && player1.contains(2))
            winner=1
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner=1
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner=1
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner=2
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner=2
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner=2
        //column
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner=1
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner=1
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner=1
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner=1
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner=1
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner=1
        //diagonally
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner=1
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner=1
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner=2
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner=2

        if(winner==1 || winner==2)
        {
            Toast.makeText(this,"Player $winner wins ",Toast.LENGTH_SHORT).show()
        }

    }
    fun autoPlay()
    {
        var emptyCell=ArrayList<Int>()
        for(cellID in 1..9)
        {
            if(!(player1.contains(cellID) || player2.contains(cellID)))
            {
                emptyCell.add(cellID)
            }
        }
        var r=java.util.Random()

        var randIndex=r.nextInt(emptyCell.size)
        var cellID=emptyCell[randIndex]
        var buSelect:Button?
        when(cellID)
        {
            1->buSelect=b01
            2->buSelect=b02
            3->buSelect=b03
            4->buSelect=b04
            5->buSelect=b05
            6->buSelect=b06
            7->buSelect=b07
            8->buSelect=b08
            9->buSelect=b09
            else->
            {
                buSelect=b01
            }
        }
        PlayGame(cellID,buSelect)
    }
}
