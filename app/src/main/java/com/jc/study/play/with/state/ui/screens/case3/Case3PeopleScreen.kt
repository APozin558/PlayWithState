package com.jc.study.play.with.state.ui.screens.case3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.constants.HeroConstants
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getNewTaskImageById
import com.jc.study.play.with.state.ext.case3.ExtCase3ImageIcons.getTaskIconById
import com.jc.study.play.with.state.models.case3.Case3GameCommonData
import com.jc.study.play.with.state.models.case3.Case3GameHeroesData
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxFab
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxHeaderSection
import com.jc.study.play.with.state.ui.screens.case3.ux.Case3uxNavigationSection
import com.jc.study.play.with.state.ui.theme.cPeopleItemBackgroundColor
import com.jc.study.play.with.state.ui.theme.cPrimaryColor
import com.jc.study.play.with.state.ui.theme.cSecondaryColor
import com.jc.study.play.with.state.ui.theme.cSelectedItemBackground

@Composable
fun Case3PeopleScreen(
    commonData: State<Case3GameCommonData>,
    onPauseClicked: () -> Unit,
    currentScreen: Int,
    isGameStarted: State<Boolean>,
    onNavigationClicked: (Int) -> Unit,
    gamePeople: State<MutableList<Case3GameHeroesData>>,
    updateTaskClicked: (newOrder:Int, selectedPeopleList:List<Int>) -> Unit
){
    val listOfSelectedPeople = remember {
        mutableStateListOf<Int>()
    }

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize().align(Alignment.TopStart)
        ) {
            Case3uxHeaderSection(
                currentScreen = currentScreen,
                onPauseClicked = onPauseClicked,
                isGameStarted = isGameStarted.value,
                commonData = commonData
            )
            Case3uxPeopleSection(
                modifier = Modifier.weight(1.0f),
                gamePeople = gamePeople,
                listOfSelectedPeople = listOfSelectedPeople
            )
            if (listOfSelectedPeople.isNotEmpty()){
                Case3uxPeopleSelectNewOrderSection(onTaskClicked = {newTask ->
                    val peopleList = listOfSelectedPeople.toList()
                    updateTaskClicked(newTask, peopleList)
                    listOfSelectedPeople.clear()
                })
            } else {
                Case3uxNavigationSection(
                    currentScreen = currentScreen,
                    onNavigationClicked = onNavigationClicked
                )
            }
        }

        Surface(
            modifier = Modifier.align(Alignment.BottomStart).padding(5.dp).padding(bottom = 50.dp)
        ) {
            Case3uxFab(
                isStarted = isGameStarted.value,
                onClick = onPauseClicked
            )
        }
    }


}

@Composable
fun Case3uxPeopleSection(
    modifier: Modifier,
    gamePeople: State<MutableList<Case3GameHeroesData>>,
    listOfSelectedPeople: SnapshotStateList<Int>
){
    val gamePeopleList = gamePeople.value

    LazyColumn(modifier = modifier
        .fillMaxWidth()
        .padding(2.dp)
    ){
        items(gamePeopleList){
            item -> Case3uxPeopleListItem(
                heroData = item,
                isSelected = item.id in listOfSelectedPeople,
                changeTaskIsPressed = {
                    if (item.id in listOfSelectedPeople)
                        listOfSelectedPeople.remove(item.id)
                    else
                        listOfSelectedPeople.add(item.id)
                }
            )
        }
    }

}

@Composable
fun Case3uxPeopleSelectNewOrderSection(onTaskClicked: (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = cPrimaryColor)
    ) {
        Text(
            modifier = Modifier.padding(top = 2.dp, bottom = 4.dp, start = 3.dp),
            text = "New order", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = cSecondaryColor
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            Case3uxPeopleSelectNewOrderItemSection(taskId = HeroConstants.TASK_NOTHING, onTaskClicked = { onTaskClicked(HeroConstants.TASK_NOTHING) })
            Spacer(modifier = Modifier.width(10.dp))
            Case3uxPeopleSelectNewOrderItemSection(taskId = HeroConstants.TASK_REST, onTaskClicked = { onTaskClicked(HeroConstants.TASK_REST) })
            Spacer(modifier = Modifier.width(10.dp))
            Case3uxPeopleSelectNewOrderItemSection(taskId = HeroConstants.TASK_WATER, onTaskClicked = { onTaskClicked(HeroConstants.TASK_WATER) })
            Spacer(modifier = Modifier.width(10.dp))
            Case3uxPeopleSelectNewOrderItemSection(taskId = HeroConstants.TASK_RAW_FOOD, onTaskClicked = {onTaskClicked(HeroConstants.TASK_RAW_FOOD)})
            Spacer(modifier = Modifier.width(10.dp))
            Case3uxPeopleSelectNewOrderItemSection(taskId = HeroConstants.TASK_SCRAP, onTaskClicked = {onTaskClicked(HeroConstants.TASK_SCRAP)})
            Spacer(modifier = Modifier.width(10.dp))
            Case3uxPeopleSelectNewOrderItemSection(taskId = HeroConstants.TASK_SCOUT, onTaskClicked = {onTaskClicked(HeroConstants.TASK_SCOUT)})
            Spacer(modifier = Modifier.weight(1.0f))
        }
    }
}

@Composable
fun Case3uxPeopleSelectNewOrderItemSection(taskId: Int, onTaskClicked: () -> Unit){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clickable(onClick = onTaskClicked)
    ){
        Image(painter = painterResource(id = getNewTaskImageById(taskId)), contentDescription = "new-task-icon")
    }
}

@Composable
fun Case3uxPeopleListItem(
    heroData: Case3GameHeroesData,
    isSelected: Boolean = false,
    changeTaskIsPressed: () -> Unit
){

    val backgroundItemColor: Color = if (isSelected) cSelectedItemBackground else cPeopleItemBackgroundColor

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(color = backgroundItemColor)
            .padding(vertical = 2.dp)
            .background(color = cPeopleItemBackgroundColor)
    ) {
        Spacer(modifier = Modifier.width(3.dp))
        Text(text = heroData.name)
        Spacer(modifier = Modifier.weight(1.0f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .width(40.dp)
                .background(color = backgroundItemColor)
                .clickable(onClick = changeTaskIsPressed)
        ){
            Image(painter = painterResource(id = getTaskIconById(heroData.currentTask)), contentDescription = "task icon")
        }
    }
}

@Preview
@Composable
fun Case3uxPeopleListItemPreview(){
    val tmpData:Case3GameHeroesData = Case3GameHeroesData(id = 0, name = "Steve Stontnberg", currentTask = HeroConstants.TASK_RAW_FOOD)
    Case3uxPeopleListItem(heroData = tmpData, isSelected = false, changeTaskIsPressed = {})
}

@Preview
@Composable
fun Case3uxPeopleSelectNewOrderSectionPreview(){
    Case3uxPeopleSelectNewOrderSection(onTaskClicked = {})
}